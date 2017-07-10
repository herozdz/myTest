package test.zoe.rpctest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-17
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
public class RpcExporter {

    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void export(String ip,int port) throws IOException {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(ip,port));

        try{
            while (true){
                executor.execute(new ExporterTask(server.accept()));
            }
        }finally {
            server.close();
        }
    }

    private static class ExporterTask implements Runnable{
        Socket client = null;

        public ExporterTask(Socket client) {
            this.client = client;
        }

        public void run() {
            ObjectInputStream  input  = null;
            ObjectOutputStream output = null;
            try {
                input = new ObjectInputStream(client.getInputStream());//从ServerSocket中获取接受client 的字节流
                String interfaceName = input.readUTF();//获取服务接口名称
                Class<?> service = Class.forName(interfaceName);//生成服务类
                String methodName = input.readUTF();//获取方法名称
                Class<?> [] paramType = (Class<?> [])input.readObject();//获取参数类型
                Object[] args = (Object[])input.readObject();//获取参数
                Method method = service.getMethod(methodName,paramType);//获取方法
                Object res = method.invoke(service.newInstance(),args);//new服务实例,调用服务方法
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(res);//向客户端返回调用结果

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(input != null){
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(output != null){
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(client != null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
