package test.zoe.concurrentTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/6/22
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 * CycliBarrier 线程到达一定数量在运行 可循环障碍物
 * 应用场景：
 *  1、多线程计算之后，最后合并结果
 *  2、做一些对账，统计
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //3个人聚餐 ，CyclicBarrier 构造函数的第二个参数runnable 是在阻塞线程全部到齐之后，首先要运行的逻辑
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("人员全部到齐，各自拍照留念。。。");
                try {
                    Thread.sleep((long)(Math.random()*10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < 3; i++) {
            final int user = i + 1;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                        //cb.getNumberWaiting() 被阻塞线程的数量
                        System.out.println("用户："+user + "到达聚餐点，当前已有"+(cb.getNumberWaiting() +1)+"到达");
                        //阻塞
                        cb.await();//第几个人到了之后 需要等待
                        System.out.println("拍照完之后，开始吃饭。。。");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("用户："+user +"吃完饭");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            };

            threadPool.execute(r);
        }
        threadPool.shutdown();

    }
}
