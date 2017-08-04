package test.zoe.common;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/14
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class SubClass1 extends AbClass{
    @Override
    public int getNum() {
        return 0;
    }

    @Override
    public String getStr() {
        return "test String";
    }

    @Override
    public String sayHello(String str) {
        return "11111";
    }
}
