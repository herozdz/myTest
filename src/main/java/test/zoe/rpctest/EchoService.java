package test.zoe.rpctest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-17
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public interface EchoService {
    @Deprecated
    String echo(String ping);
    @Deprecated
    String echoOther(int i, String ping);
}
