package test.zoe.threadLocalTest;

import com.alibaba.fastjson.JSON;

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
public class MTest2 {
    public static void main(String[] args) {
        LoginContext1 loginContext = new LoginContext1();
        loginContext.setAccount("main-zoudezhu");
        loginContext.setPin("pin-zoudezhu");
        LoginContext1.setLoginContext(loginContext);
        System.out.println("main:"+Thread.currentThread().getName()+
                "-->" + JSON.toJSONString(LoginContext1.getLoginContext()));
        ThreadLocal<LoginContext1> local = LoginContext1.getHolder();
        ExecutorService executorService = null;
        executorService = CommonConfig.getThreadPool(2, 2,CommonConfig.THREAD_QUEUE_CAPACITY1K);
       // executorService = TtlExecutors.getTtlExecutorService(executorService);
        TestTask2 t1 = new TestTask2(loginContext);
        TestTask2_1 t2 = new TestTask2_1(loginContext);
        long time1 = System.currentTimeMillis();
        Future<String> f1 =  executorService.submit(t1);
        Future<String> f2  = executorService.submit(t2);
        try {

            System.out.println("f1:"+(String)f1.get());
            System.out.println("f2:"+(String)f2.get());
            System.out.println( "time:" + (System.currentTimeMillis() - time1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

        System.out.println("main:"+Thread.currentThread().getName()+
                "-->" + JSON.toJSONString(LoginContext1.getLoginContext()));
    }
       
     
}
