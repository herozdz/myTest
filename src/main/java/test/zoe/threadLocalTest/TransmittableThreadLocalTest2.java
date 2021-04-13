package test.zoe.threadLocalTest;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransmittableThreadLocalTest2 {
    public static ThreadLocal<Stu> threadLocal = new MyTransmittableThreadLocal<>();
    public static ExecutorService executorService =
            TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开启");
        threadLocal.set(new Stu("aa",1));
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() -> {
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);

        threadLocal.get().setAge(2);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() -> {
            //[读到了主线程修改后的新值]
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.get().setAge(3);
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);
        //读取的是2. 原因是因为这里依旧是值传递，主子线程中引用的实际是同一个对象！！
        //如果想传值，则重写TransmittableThreadLocal的copy即可
        System.out.println("主线程读取本地变量：" + threadLocal.get());
    }
}

