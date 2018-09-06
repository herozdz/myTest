package test.zoe.maptest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 18-8-16
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrentMapTest {
    public static void main(String[] args) {
        //测试一下currentHashMap.putIfAbsent()

        Map<Long, String> clientMap = new ConcurrentHashMap<Long, String>();

        System.out.println("首先打印空的clientMap");
        System.out.println("clientMap: " + clientMap);
        System.out.println();

        //在空的clientMap中添加一个新的记录
        System.out.println("在空的clientMap中添加一个新的记录");
        System.out.println("添加之前的clientMap: " + clientMap);
        Long netId = 1234567L;
        String str1 = "michael-1";
        String result = clientMap.putIfAbsent(netId, str1);
        System.out.println("添加之后的clientMap: " + clientMap);
        System.out.println("查看返回值result: " + result);
        System.out.println();

        //重复添加
        System.out.println("重复添加上一次的记录");
        System.out.println("添加之前的clientMap: " + clientMap);

        String  str2 = "zoudezhu111";
        String result2 = clientMap.putIfAbsent(netId, str2);
        System.out.println("添加之后的clientMap: " + clientMap);
        System.out.println("查看返回值result: " + result2);
        System.out.println();

        // clientMap.p
    }
}
