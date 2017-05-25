

package common;

import org.junit.Test;

/**
 * jupiter
 * org.jupiter.serialization.hessian
 *
 * @author jiachun.fjc
 */
public class CommonTest {

    @Test
    public void testSerializer() {
        //byte[] b = new byte[]{1,2,3,6,22,12,13,32,21,23};
        //System.out.println("res:"+bytes2Int(b,0,3));
        Boolean ab = new Boolean(true);
        Boolean bb = new Boolean(false);
        int b = 5;
        this.va(ab,bb);
        this.vb(b);
        System.out.println(ab);
        System.out.println(b);

    }

    public void va(Boolean a,Boolean b){
        a = null;
        a = b;
        a.booleanValue();
    }

    public void vb(int x){
        int a = x;
        int b = 10;
       int tmp = a;
        a = b;
        b = tmp;
    }

    public  int bytes2Int(byte[] bytes, int start, int length) {
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


}

