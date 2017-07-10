package testRpc;


import test.zoe.rpctest.EchoService;
import test.zoe.rpctest.EchoServiceImpl;
import test.zoe.rpctest.RpcImporter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-17
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public class TestInvoke {
    public static void main(String[] args) {
        RpcImporter<EchoService> rpcImporter = new RpcImporter<EchoService>();
        EchoService echoService = rpcImporter.importer(EchoServiceImpl.class,new InetSocketAddress("127.0.0.1",18011));
        System.out.println(echoService.echo("zoudezhu say:are you ok?"));
        System.out.println("no body say:" + echoService.echo(null));
    }
}
