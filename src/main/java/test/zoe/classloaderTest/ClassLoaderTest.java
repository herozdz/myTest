package test.zoe.classloaderTest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 18-8-1
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // TODO Auto-generated method stub

        ClassLoader cl = Test.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());

        System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());

        //System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());


        /**
         * 上面张贴这么多代码也是为了说明AppClassLoader的parent是ExtClassLoader，
         * ExtClassLoader的parent是null。Ext 的parent 是bootstrapClassloader，它是C++写的，程序获取不到。
         * */
        cl = int.class.getClassLoader();
        /**
         *
         * */
        //System.out.println("ClassLoader is:"+cl.toString());

        ClassLoader cd = Thread.currentThread().getContextClassLoader();

        System.out.println("Thread.currentThread().getContextClassLoader()-->"+Thread.currentThread().getContextClassLoader());

        System.out.println("ClassLoader.getSystemClassLoader();-->"+ClassLoader.getSystemClassLoader());

        Class c = Class.forName("test.zoe.classloaderTest.Test");
        System.out.println("c.getClassLoader()-->"+c.getClassLoader());

    }
}
