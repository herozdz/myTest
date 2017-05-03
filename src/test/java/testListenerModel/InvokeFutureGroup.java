package testListenerModel;

/**
 *
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/4/14
 * Time: 19:00
 * To change this template use File | Settings | File Templates.
 */
public interface InvokeFutureGroup<V> extends InvokeFuture<V> {
    InvokeFuture<V>[] futures();
}
