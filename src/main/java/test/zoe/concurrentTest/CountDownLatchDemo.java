package test.zoe.concurrentTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/6/22
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 * 有一个任务，它需要等待其他某几个任务执行之后才能执行
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //等待2个线程任务
        final CountDownLatch latch = new CountDownLatch(2);
        //任务1
        new Thread(){
            public void run(){
                try {
                    System.out.println("任务1正在执行任务！");
                    Thread.sleep((long)(Math.random()*10000));
                    System.out.println("任务1执行完成！");
                    latch.countDown();//计数器减一
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //任务2
        new Thread(){
            public void run(){
                try {
                    System.out.println("任务2正在执行任务！");
                    Thread.sleep((long)(Math.random()*10000));
                    System.out.println("任务2执行完成！");
                    latch.countDown();//计数器减一
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
//主线程
        System.out.println("等待其他2个任务执行完毕，主线程才开始执行"+Thread.currentThread().getName());
        latch.await();//同步点，阻塞点
        System.out.println("等待其他2个任务执行完毕，主线正在程执行任务。。");
    }

}
