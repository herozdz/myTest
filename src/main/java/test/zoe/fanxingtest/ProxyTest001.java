package test.zoe.fanxingtest;


import test.zoe.rpctest.EchoService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-18
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */
public class ProxyTest001 {

    public static void main(String[] args) throws ClassNotFoundException {
        EchoService echoService = (EchoService)testClass();
        //String res = echoService.echo("aaaaa");
        //System.out.println("res:"+res);

        System.out.println("-----------------------");
        String res1 = echoService.echoOther(1,"121");
        System.out.println("res1:"+res1);
        /*List<String> list = new ArrayList<String>();
        list.add("aaa");
        Class c = list.getClass();
        try{
            Method method = c.getMethod("add",Object.class);
            method.invoke(list,100);
            method.invoke(list,500.25);
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    public static Object testClass() throws ClassNotFoundException {
        Class<?> a =  Class.forName("test.zoe.rpctest.EchoServiceImpl");

        Object o = Proxy.newProxyInstance(a.getClassLoader(),
                new Class[]{a.getInterfaces()[0]},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method.getName():"+method.getName());
                        System.out.println("method.getParameterTypes():"+method.getParameterTypes()[0]+","+method.getParameterTypes()[1]);
                        System.out.println("method.getAnnotations():"+method.getAnnotations()[0]);
                        System.out.println("args:"+args[0]+","+args[1]);
                        Object o = method.invoke(Class.forName("test.zoe.rpctest.EchoServiceImpl").newInstance(),args);
                        return o ;
                    }
                }
        );
        System.out.println(a.getInterfaces()[0]);
        return o;
    }
}
