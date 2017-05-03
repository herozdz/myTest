package testArrayCopy;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/4/10
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        byte[] src = new byte[]{1,2,3,4,5,6,7};
        System.out.println(src.length);
        for(byte b:src){
            System.out.println("src:"+b);
        }
        System.out.println("*******************");
        byte[] dest = new byte[]{11,12,13,14,15,16,17};
        for(byte b:dest){
            System.out.println("dest copy before:"+b);
        }
        System.out.println("*******************");
        System.arraycopy(src,2,dest,2,5);

        for(byte b:dest){
            System.out.println("dest copy after:"+b);
        }
        System.out.println("");
    }
}
