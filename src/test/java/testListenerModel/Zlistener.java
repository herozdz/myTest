package testListenerModel;

import java.util.EventListener;

/**
 * Call back
 * {@link #complete(Object)} and {@link #failure(Throwable)}
 *
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/4/14
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
public interface Zlistener<V> extends EventListener {

    /**
     * success return
     * */
    void complete(V result);

    /**
     * fail return
     * */
    void failure(Throwable throwable);

}
