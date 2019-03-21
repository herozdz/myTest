package test.zoe.threadLocalTest;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 19-3-19
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class MTest1 {
    public static void main(String[] args) {
        LoginContext1 loginContext = new LoginContext1();
        loginContext.setAccount("main-zoudezhu");
        loginContext.setPin("pin-zoudezhu");
        LoginContext1.setLoginContext(loginContext);

        ThreadLocal<LoginContext1> local = LoginContext1.getHolder();
        ExecutorService executorService = null;
        executorService = CommonConfig.getThreadPool(2, 2,CommonConfig.THREAD_QUEUE_CAPACITY1K);
       // executorService = TtlExecutors.getTtlExecutorService(executorService);
        TestTask1 t1 = new TestTask1(loginContext);
        TestTask1 t2 = new TestTask1(loginContext);

        Future<String> f1 =  executorService.submit(t1);

        Future<String> f2  = executorService.submit(t2);
        System.out.println("main:"+Thread.currentThread().getName()+
                "-->account:"+LoginContext1.getLoginContext().getAccount()+
                ",pin:"+LoginContext1.getLoginContext().getPin());
        try {
            System.out.println("f1:"+(String)f1.get());
            System.out.println("f2:"+(String)f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

        System.out.println("main:"+Thread.currentThread().getName()+
                "-->account:"+LoginContext1.getLoginContext().getAccount()+
                ",pin:"+LoginContext1.getLoginContext().getPin());
    }
       
     
}
