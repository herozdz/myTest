package test.zoe.proxy.test;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 18-9-6
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<Long>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}