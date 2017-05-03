package testListenerModel;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/4/14
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public interface ListenableFuture<V> {

    /**
     * {@link }
     * add a listener to the future
     * */
    ListenableFuture<V> addListener(Zlistener<V> zlistener);

    /**
     * {@link }
     * add many listener to the future
     * */
    ListenableFuture<V> addListeners(Zlistener<V> ... zlistener);

    /**
     * {@link }
     * remove a listener to the future
     * */
    ListenableFuture<V> removeListener(Zlistener<V> zlistener);


    /**
     * {@link }
     * remove many listener to the future
     * */
    ListenableFuture<V> removeListeners(Zlistener<V> ... zlistener);

}
