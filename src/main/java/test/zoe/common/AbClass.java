package test.zoe.common;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/14
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public abstract class  AbClass implements Inter{
    public abstract int getNum();
    public abstract String getStr();
    public String sayHi(String str){
        return "hello:"+str;
    }
}
