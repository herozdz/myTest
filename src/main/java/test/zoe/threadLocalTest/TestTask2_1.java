package test.zoe.threadLocalTest;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 19-3-19
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
public class TestTask2_1 implements Callable<String> {
    private LoginContext1 loginContext;


    public TestTask2_1(LoginContext1 loginContext) {
        this.loginContext = loginContext;
    }

    @Override
    public String call() throws Exception {
        LoginContext1.setLoginContext(loginContext);
        LoginContext1 loginContext = LoginContext1.getLoginContext();
        String account = loginContext.getAccount();
        String pin     = loginContext.getPin();
        Thread.sleep(3000);
        loginContext.setChannel(Thread.currentThread().getName() + "-channel");
        String res = Thread.currentThread().getName()+"-->account:"+account+",pin:"+pin;
        LoginContext1.removeLoginContext();
        return  Thread.currentThread().getName()+"-->"+JSON.toJSONString(loginContext);
    }
}
