package test.zoe.threadPool;


/**
 * @author Zoe
 * @date 2020-01-15 09:43
 */
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class ExecutorsDemo implements Runnable {

    private int i = 0;

    public ExecutorsDemo(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1));

        for (int i = 0; i < 3; i++) {
            executor.execute(new ExecutorsDemo(i));
            /**1、如果没有设置allowCoreThreadTimeOut参数，无论keepAliveTime设置多大,核心线程数量corePoolSize个数的线程
             * 都不会被kill掉，
             * 2、如果设置了allowCoreThreadTimeOut参数true ，核心线程会在keepAliveTime秒数 被kill掉*/
            //executor.allowCoreThreadTimeOut(true);
        }
        while (true) {
            System.out.println("总线程数：" + executor.getPoolSize()
                          + ",当前活跃线程数：" + executor.getActiveCount()
                            +",getTaskCount:"+executor.getTaskCount()
                            +",getCompletedTaskCount:"+executor.getCompletedTaskCount());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("i=" + i + " Thread = " + Thread.currentThread().getName());
        if (i >= 1) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("i=" + i + " sleep 1 s结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("i=" + i + " sleep 3 s结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}