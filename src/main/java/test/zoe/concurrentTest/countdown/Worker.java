package test.zoe.concurrentTest.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2019/3/11
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
public class Worker implements Runnable{

    private CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name){
        this.downLatch = downLatch;
        this.name = name;
    }

    public void run() {
        this.doWork();
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch(InterruptedException ie){
        }
        System.out.println(this.name + "活干完了！");
        this.downLatch.countDown();

    }

    private void doWork(){
        System.out.println(this.name + "正在干活!");
    }

}