package test.zoe.bitmap;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/5/1
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 * 位图法
 */
public class BitMapTest {

    public static void main(String[] args) {
        int data[] = new int[]{5,6,6,3,3,2,1,10,11,4};
        int b[] = new int[12];
        for(int i=0;i<data.length;i++){
            if(b[data[i]] != 1){
                b[data[i]] = 1;
            }else{
                System.out.println("重复数字："+data[i]);
            }
        }

        byte by[] = new byte[12];
        for(int i=0;i<data.length;i++){
            if(by[data[i]] != 1){
                by[data[i]] = 1;
            }else{
                System.out.println("by重复数字："+data[i]);
            }
        }

        int var = 0;
        var = 9;
        System.out.println(by[var]==1);
        System.out.println("data.length"+data.length);

        String res = "";
        for(int j =0 ;j<by.length;j++){
            if(by[j] == 1){
                res += j+",";
            }
        }
        System.out.println("res ="+res);
        System.out.println();

    }

}
