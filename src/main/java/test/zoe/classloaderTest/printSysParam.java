package test.zoe.classloaderTest;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 18-8-1
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
public class printSysParam {

    public static void main(String[] args) {
        printSystemPropertiesToConsole();
    }

    public static void printSystemPropertiesToConsole(){
        Set<Map.Entry<Object, Object>> entrySet = System.getProperties().entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entrySet.iterator();
        while( iterator.hasNext() ){
            System.err.println(iterator.next().toString());
        }
    }
}
