package test.zoe.concurrentTest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/6/22
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 * 应用场景：
 * 1、用于2个线程交换数据
 * 2、做校对工作
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        //交换器，交换2个线程的内容
        final Exchanger<String> ec = new Exchanger<String>();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //张三团伙
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String res = null;
                try {
                    res = ec.exchange("小乔");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("绑架者用小乔交换回："+res);
            }
        });


        //大乔
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String res = null;
                try {
                    Thread.sleep((long)(Math.random()*10000));
                    Thread.sleep((long)(Math.random()*10000));
                    res = ec.exchange("1000万");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("大乔用1000万交换小乔："+res);
            }
        });
    threadPool.shutdown();
    }
}
