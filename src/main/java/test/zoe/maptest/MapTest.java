package test.zoe.maptest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        /*******************/
        System.out.println("*******************");
        int size = 35;
        GMap<String ,String > groupMap = new GroupMap<String, String>(7);
        Date inputBeginTime = new Date();
       /* for(int i =0;i<size;i++ ){
            groupMap.putValue("123","123456789-"+i);
            groupMap.putValue("234","123456789-"+i);
            groupMap.putValue("345","123456789-"+i);
            groupMap.putValue("456","123456789-"+i);
            groupMap.putValue("567","123456789-"+i);
            groupMap.putValue("678","123456789-"+i);
            groupMap.putValue("789","123456789-"+i);
        }
        Date inputEndTime = new Date();

*/
        //System.out.println("intput time = " + dateDiff(inputBeginTime,inputEndTime,null));

        groupMap.putValue("123","123456abc");
        groupMap.putValue("234","123456abc");
        groupMap.putValue("345","123456abc");
        groupMap.putValue("456","123456abc");
        groupMap.putValue("123","123456abc");


        groupMap.putValue("123","123456efg");
        groupMap.putValue("234","123456efg");
        groupMap.putValue("345","123456efg");
        groupMap.putValue("456","123456efg");
        groupMap.putValue("567","123456efg");
        groupMap.putValue("678","12345678efg");
        groupMap.putValue("789","123456789efg");

        groupMap.putValue("456","456a");
        groupMap.putValue("456","456b");
        groupMap.putValue("456","456c");
        groupMap.putValue("456","456d");


        /*for(GMap.Entry<String , String > entry : groupMap.entrySet()){
            System.out.println("m.key.hashCode()-->:"+entry.getKey().hashCode()+
                    ",m.key-->:"+entry.getKey()+",m.value-->:"+entry.getValue()
                    +",m.value.hashCode-->:"+entry.getValue().hashCode());
        }*/


        Set<String> ks = new HashSet<String>();
        Date outputBeginTime = new Date();
        // 遍历方法四 treemap keySet()遍历
        for (Object o : groupMap.keySet()) {
            ks.add((String)o);
            //groupMap.getValue(o).size();
            System.out.println("key=" + o + " value=" +groupMap.getValue(o).size());
            //
        }

        System.out.println("************************");
        System.out.println("------>size="+ks.size());
        for (String k : ks) {
            groupMap.getValue(k);
            System.out.println("key=" + k + ", value=" + groupMap.getValue(k));
        }
        Date outputEndTime = new Date();
        System.out.println("ontput time = " + dateDiff(outputBeginTime,outputEndTime,null));

    }

    public static String dateDiff(Date startTime, Date endTime, String format) {
//按照传入的格式生成一个simpledateformate对象
        //SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
        long nh = 1000 * 60 * 60;//一小时的毫秒数
        long nm = 1000 * 60;//一分钟的毫秒数
        long ns = 1000;//一秒钟的毫秒数long diff;try {
        //获得两个时间的毫秒时间差异
        long diff;
        diff = endTime.getTime() - startTime.getTime();
        long day = diff / nd;//计算差多少天
        long hour = diff % nd / nh;//计算相差剩余多少小时
        long hour2 = diff / nh; //计算相差多少小时
        long min = diff % nd % nh / nm;//计算差多少分钟
        long sec = diff % nd % nh % nm / ns;//计算差多少秒//输出结果
        if(sec == 0){
            return diff+"毫秒";
        }else {
            return "时间相差：" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒。";
        }
        //System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒。");
    }
}
