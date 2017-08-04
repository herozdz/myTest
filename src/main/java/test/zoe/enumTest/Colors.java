package test.zoe.enumTest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/14
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public enum Colors {
    RED("红色",1),GREEN("绿色",2),BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    Colors(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
