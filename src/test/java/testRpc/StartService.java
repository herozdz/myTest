package testRpc;

import test.zoe.rpctest.RpcExporter;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 16-11-17
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
public class StartService {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.export("127.0.0.1",18011);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
