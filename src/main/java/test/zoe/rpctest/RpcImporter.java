package test.zoe.rpctest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-17
 * Time: 上午11:09
 * To change this template use File | Settings | File Templates.
 */
public class RpcImporter<S>  {

    public S importer(final Class<?> serviceClass, final InetSocketAddress adds){

        return (S) Proxy.newProxyInstance(//生成动态代理类(服务接口)
                serviceClass.getClassLoader(),//加载服务类classloader
                new Class<?>[] {serviceClass.getInterfaces()[0]},//接口
                new InvocationHandler(){//调用句柄
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectInputStream input = null;
                        ObjectOutputStream output = null;
                        try {
                            socket = new Socket();
                            socket.connect(adds);//连接远程rpc服务
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());//向远程输出流写调用接口名称
                            output.writeUTF(method.getName());//向远程输出流写调用方法名称
                            output.writeObject(method.getParameterTypes());//向远程输出流写方法类型
                            output.writeObject(args);//向远程输出流写方法参数
                            input = new ObjectInputStream(socket.getInputStream());//读取调用远程rpc服务结果
                            return input.readObject();//返回远程rpc代理类
                        }finally {
                            if(socket != null){
                                socket.close();
                            }
                            if(input != null){
                                input.close();
                            }
                            if(output != null){
                                output.close();
                            }
                        }
                    }
                }
                );

    }
}
