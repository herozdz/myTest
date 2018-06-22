package test.zoe.concurrentTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/6/22
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 * Semaphore 信号量 限制线程运行数量。
 * 应用场景：
 * 1，限流
 * 2，限制稀有资源，数据库连接，打印机的接口等
 *  和数据库连接 限制。
 */
public class SemaphoreDemo {
    /**
     * 执行任务类，获取信号量和释放信号量
     * */
    class SemaphoreRunnable implements Runnable{
        private Semaphore semaphore;
        private int user;

        public SemaphoreRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try{
                //获取信号量许可
                semaphore.acquire();
                System.out.println("用户【"+user+"】,进入窗口，准备买票。。。");
                Thread.sleep((long)(Math.random()*10000));
                System.out.println("用户【"+user+"】,买票完成，即将离开离开。。。");
                Thread.sleep((long)(Math.random()*10000));
                System.out.println("用户【"+user+"】,离开窗口。。。");
                //释放信号量
                semaphore.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private void execute(){
        //定义窗口个数
        final Semaphore semaphore = new Semaphore(2);
        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟20个用户
        for(int i = 0;i<20;i++){
            //去买票
            threadPool.execute(new SemaphoreRunnable(semaphore,(i+1)));

        }
        threadPool.shutdown();

    }

    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        semaphoreDemo.execute();
    }
}
