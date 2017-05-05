package test.zoe.common;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/28
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */
public class Common {
    public static void main(String[] args) {
        /*int i = 7;
        System.out.println("i/  :"+i/3);
        System.out.println("i%  :"+i%3);*/
        System.out.println("位移：" + (5<<3));
        //testA();
        byte[] b = new byte[]{1,2,3,6,22,12,13,32,21,23};
        System.out.println("res:"+bytes2Int(b,0,2));
    }


    /**
     *
     * 43210      位数
     --------
     1010      十进制：10     原始数         number
     10100      十进制：20     左移一位       number = number << 1;
     1010      十进制：10     右移一位       number = number >> 1;
     * */
    public static int bytes2Int(byte[] bytes, int start, int length) {
        int sum = 0;
        int end = start + length;
        for (int i = start; i < end; i++) {
            int n = bytes[i] & 0xff;
            /*int tmp = --length;
            System.out.println("--length:"+tmp);*/
            n <<= (--length) * 8;
            sum += n;
        }
        return sum;
    }

    public static void testA(){
        int a = 5;
        for(int i = 0;i<5;i++){
            System.out.println("a:" + a);
           System.out.println("a-- :" + a--);
            //System.out.println("--a :" + --a);
            System.out.println("a:" + a);

        }
    }
}
