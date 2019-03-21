package test.zoe.threadLocalTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 17-11-22
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class CommonConfig {

    public final static String SEND_MAIL_QUEUE = "SEND_MAIL_QUEUE";

    //当前机器的核数
    public final static int CPU_CORE_NUM = Runtime.getRuntime().availableProcessors();

    public final static int SLEEP_TIME_SECOND = 10000;//间隔秒数
    public final static int WAIT_A_MINUTE = 6000;//系统启动后等一会在开始，等所有资源都加载完成
    public final static int WAIT_4RST_MINUTE = 3;//等待保存结果任务执行结束时间
    public final static int IDLE_COUNT = 5;//关闭 线程池的次数
    public final static int THREAD_QUEUE_CAPACITY1 = 10;//线程池中最多等待个数
    public final static int THREAD_QUEUE_CAPACITY5 = 50;//线程池中最多等待个数
    public final static int THREAD_QUEUE_CAPACITY1K = 2;//线程池中最多等待个数

    public static ExecutorService getThreadPool(int corePoolSize,int maximumPoolSize, int queueCapacity){
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(queueCapacity), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
