package testListenerModel;

import static  common.Preconditions.checkNotNull;

/**
 * * 异步调用上下文, 用于获取当前上下文中的 {@link InvokeFuture}, 基于 {@link ThreadLocal}.
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/4/14
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("unchecked")
public class InvokeFutureContext {

    private static final ThreadLocal<InvokeFuture<?>> futureThreadLocal = new ThreadLocal<InvokeFuture<?>>();

    public static InvokeFuture<?> future(){
        InvokeFuture<?> future = checkNotNull(futureThreadLocal.get(),"future");
        futureThreadLocal.remove();
        return  future;
    }

    public static <V> InvokeFutureGroup<V> futureBroadcast(Class<V> returnClass){
        InvokeFuture<?> f = future();
        checkReturnType(f.returnType(),returnClass);
        if(f instanceof InvokeFutureGroup){
            return (InvokeFutureGroup<V>) f;
        }
        throw new UnsupportedOperationException("broadcast");
    }

    private static void checkReturnType(Class<?> realType, Class<?> expectType) {
        if (!expectType.isAssignableFrom(realType)) {
            throw new IllegalArgumentException(
                    "illegal returnType, expect type is ["
                            + expectType.getName()
                            + "], but real type is ["
                            + realType.getName() + "]");
        }
    }


}
