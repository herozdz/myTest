package test.zoe.maptest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/2/11
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
public class MapTest {
    public static void main(String[] args) {
        Date nowdate = new Date();
        System.out.println("nowdate:"+nowdate);
        Date nowdate1 = new Date(nowdate.getTime() + 24 * 60 * 60 *1000L);
        System.out.println("nowdate1:"+nowdate1);
        /*Map<Element , String > m = new HashMap<Element ,String>(10);
        Element e1 = new Element();
        e1.setIndex(123);
        e1.seteVale("123456abc");

        Element e2 = new Element();
        e2.setIndex(234);
        e2.seteVale("123456abc");

        Element e3 = new Element();
        e3.setIndex(345);
        e3.seteVale("123456abc");

        Element e4 = new Element();
        e4.setIndex(456);
        e4.seteVale("123456abc");

        m.put(e1,"123456abc");
        m.put(e2,"123456abc");
        m.put(e3,"123456abc");
        m.put(e4,"123456abc");
        *//*******************************//*

        Element e5 = new Element();
        e5.setIndex(123);
        e5.seteVale("123456efg");

        Element e6 = new Element();
        e6.setIndex(234);
        e6.seteVale("123456efg");

        Element e7 = new Element();
        e7.setIndex(345);
        e7.seteVale("123456efg");

        Element e8 = new Element();
        e8.setIndex(456);
        e8.seteVale("123456efg");

        m.put(e5,"123456efg");
        m.put(e6,"123456efg");
        m.put(e7,"123456efg");
        m.put(e8,"123456efg");

        for(Map.Entry<Element , String > entry : m.entrySet()){
            System.out.println("m.key.hashCode()-->:"+entry.getKey().hashCode()+
                    ",m.key-->:"+entry.getKey()+",m.value-->:"+entry.getValue()
                    +",m.value.hashCode-->:"+entry.getValue().hashCode());
        }

        System.out.println("getOne-->"+m.get(e7));

        int capacity = 1;
        int initialCapacity = 10;
        while (capacity < initialCapacity)
            capacity <<= 3;
        System.out.println("capacity:"+capacity);*/


        /*******************/
        System.out.println("*******************");
        GMap<String ,String > groupMap = new GroupMap<String, String>(15);
        groupMap.putValue("123","123456abc");
        groupMap.putValue("234","123456abc");
        groupMap.putValue("345","123456abc");
        groupMap.putValue("456","123456abc");
        groupMap.putValue("123","123456abc");


        groupMap.putValue("123","123456efg");
        groupMap.putValue("234","123456efg");
        groupMap.putValue("345","123456efg");
        groupMap.putValue("456","123456efg");

        groupMap.putValue("456","456a");
        groupMap.putValue("456","456b");
        groupMap.putValue("456","456c");
        groupMap.putValue("456","456d");





        System.out.println("key:123-->" + groupMap.getValue("123"));
        System.out.println("key:234-->" + groupMap.getValue("234"));
        System.out.println("key:345-->" + groupMap.getValue("345"));
        System.out.println("key:456-->" + groupMap.getValue("456"));

        for(GMap.Entry<String , String > entry : groupMap.entrySet()){
            System.out.println("m.key.hashCode()-->:"+entry.getKey().hashCode()+
                    ",m.key-->:"+entry.getKey()+",m.value-->:"+entry.getValue()
                    +",m.value.hashCode-->:"+entry.getValue().hashCode());
        }


        Set<String> ks = new HashSet<String>();
        // 遍历方法四 treemap keySet()遍历
        for (Object o : groupMap.keySet()) {
            ks.add((String)o);
            System.out.println("key=" + o + " value=" + groupMap.getValue(o));
        }
        System.out.println("************************");
        for (String k : ks) {
            System.out.println("key=" + k + ", value=" + groupMap.getValue(k));
        }

    }
}
