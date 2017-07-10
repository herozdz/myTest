package test.zoe.rpctest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-17
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public class EchoServiceImpl implements EchoService {

    public String echo(String ping) {
        return ping != null?ping + "i am ok!":"no ok!";
    }

    @Override
    public String echoOther(int i, String ping) {
        return "i:"+i +",ping:"+ping;
    }


}
