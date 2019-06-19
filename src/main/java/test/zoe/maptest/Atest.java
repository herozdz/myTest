package test.zoe.maptest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 19-5-31
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
public class Atest {

    public static void main(String[] args) {
        GMap<String ,String > groupMap = new GroupMap<String, String>(7);
        groupMap.put("1","woshi1");
        groupMap.put("1","woshi2");
        System.out.println("1-->:"+groupMap.get("1"));

    }
}
