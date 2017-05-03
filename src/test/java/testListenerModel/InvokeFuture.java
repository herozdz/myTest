package testListenerModel;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/4/14
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public interface InvokeFuture<V> extends ListenableFuture<V> {

    Class<V> returnType();

    /**
     * Waits for this future to be completed and get the result.
     */
    V getResult() throws Throwable;
}
