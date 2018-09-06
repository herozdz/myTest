package test.zoe.proxy.test;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 18-9-6
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class writeFile {
    public static void main(String[] args) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "/data/zoudezhu/demo/StuProxy.class";
        try{
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
