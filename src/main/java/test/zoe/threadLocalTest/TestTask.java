package test.zoe.threadLocalTest;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 19-3-19
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
public class TestTask implements Callable<String> {
    private ThreadLocal<LoginContext> holder;


    public TestTask(ThreadLocal<LoginContext> holder) {
        this.holder = holder;
    }

    @Override
    public String call() throws Exception {
        LoginContext loginContext = holder.get();
        String account = loginContext.getAccount();
        String pin     = loginContext.getPin();
        return Thread.currentThread().getName()+"-->account:"+account+",pin:"+pin;
    }
}
