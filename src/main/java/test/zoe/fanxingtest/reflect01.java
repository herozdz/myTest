package test.zoe.fanxingtest;

import rpctest.EchoService;

import java.lang.reflect.*;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-14
 * Time: 下午5:35
 * To change this template use File | Settings | File Templates.
 */
public class reflect01 {
    private int a;
        public int sum(int a, int b) {
            return a + b;
        }
        public String addStr(String str) {
            return "This is the:" + str;
        }

    public <T> T buildError(Class<T> c) throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        T t = c.newInstance();
        Field[] fields = c.getFields();
        c.getMethod("",new Class[]{int.class});
        for(Field field:fields){
            field.getName();
        }
        return t;
    }
        public static void main(String[] args) throws Exception {
            Class<?> classType = reflect01.class;
            // Object reflect01 = classType.newInstance();
            Constructor<?> constructor = classType.getConstructor(new Class[] {});
            Object reflect01 = constructor.newInstance(new Object[] {});
            System.out.println(classType.getDeclaredField("a"));
            // 通过反射进行反射出类中的方法
            Method sumMethod = classType.getMethod("sum", new Class[] { int.class,
                    int.class });
            //invoke方法的值永远只是对象
            Object result1 = sumMethod.invoke(reflect01, new Object[] { 6, 10 });
            System.out.println((Integer) result1);
            Method addStrMethod = classType.getMethod("addStr",
                    new Class[] { String.class });
            Object result2 = addStrMethod.invoke(reflect01,
                    new Object[] { "tom" });
            System.out.println((String) result2);

            System.out.println("-------------------------");
            EchoService ref = (EchoService)getProxy01();
            String  res01 = ref.echo("hi ~~~~");
            System.out.println("res01---->:" + res01);

        }

        public static Object getProxy01() throws ClassNotFoundException {
            final Class<?> clazz = Class.forName("rpctest.EchoServiceImpl");
            Object oo = Proxy.newProxyInstance(clazz.getClassLoader(),
                    new Class[]{clazz.getInterfaces()[0]},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Object o =null;
                            o = method.invoke(clazz.newInstance(),args);
                            return  o;
                        }
                    });
            return oo;

        }
    }


