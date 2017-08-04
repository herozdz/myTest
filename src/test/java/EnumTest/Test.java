package EnumTest;

import test.zoe.enumTest.Colors;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/14
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    @org.junit.Test
    public void testE(){
        Colors c =   Colors.RED;
        System.out.println(c.getIndex() +":"+c.getName());

        for(Colors colors:Colors.values()){
            System.out.println(colors.getIndex() +":"+colors.getName());
        }
    }
}
