package testFuture;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.Test;
import test.zoe.future.*;
import test.zoe.utils.ExecResult;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/6/22
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class testFuture {

    @Test
    public void testSerializer() {


        final InvokeFutureGroup<ExecResult> future = InvokeFutureContext.futureBroadcast(ExecResult.class);
        future.addListener(new JListener<ExecResult>() {

            @Override
            public void complete(ExecResult result) {
                synchronized (future) {
                    System.out.println("= debug info ======================================");
                    System.out.println(result.getDebugInfo());
                    System.out.println("= return value ====================================");
                    System.out.println(result.getValue());
                    System.out.println();
                    System.out.println();
                }
            }

            @Override
            public void failure(Throwable cause) {
                cause.printStackTrace();
            }
        });
    }

    public void createFuture(){
        //InvokeFuture<?> future = new FailSafeInvokeFuture.with();
        //InvokeFutureContext.set(future);
    }
/*    @RuntimeType
    public Object invoke(@Origin Method method, @AllArguments @RuntimeType Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?> returnType = method.getReturnType();
        ClusterInvoker invoker = getClusterInvoker(methodName);
        InvokeFuture<?> future = invoker.invoke(methodName, args, returnType);
        InvokeFutureContext.set(future);
        return Reflects.getTypeDefaultValue(returnType);
    }*/

}
