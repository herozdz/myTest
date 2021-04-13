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

    @Override
    public String call() throws Exception {
        System.out.println("childThread:"+Thread.currentThread().getName()+
                "-->account:"+LoginContext.getLoginContext().getAccount()+
                ",pin:"+LoginContext.getLoginContext().getPin());
        return Thread.currentThread().getName()+"-->account:"+LoginContext.getLoginContext().getAccount()+
                ",pin:"+LoginContext1.getLoginContext().getPin();
    }
}
