package test.zoe.threadLocalTest;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.apache.cxf.feature.Feature;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 19-3-19
 * Time: 上午9:25
 * To change this template use File | Settings | File Templates.
 */
public class MTest {

    public static void main(String[] args)  {
        LoginContext loginContext = new LoginContext();
        loginContext.setAccount("main-zoudezhu");
        loginContext.setPin("pin-zoudezhu");
        LoginContext.setLoginContext(loginContext);

        ThreadLocal<LoginContext> local = LoginContext.getHolder();
        ExecutorService executorService = null;
        executorService = CommonConfig.getThreadPool(2, 2,CommonConfig.THREAD_QUEUE_CAPACITY1K);
        executorService = TtlExecutors.getTtlExecutorService(executorService);
        TestTask t1 = new TestTask(local);
        TestTask t2 = new TestTask(local);

        Future<String> f1 =  executorService.submit(t1);

        Future<String> f2  = executorService.submit(t2);
        System.out.println("main:"+Thread.currentThread().getName()+
                "-->account:"+LoginContext.getLoginContext().getAccount()+
                ",pin:"+LoginContext.getLoginContext().getPin());
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


    }

}
