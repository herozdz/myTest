package test.zoe.enumTest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/14
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class EnumTest {
    Color color = Color.RED;
    public void change() {
        switch (color) {
            case RED:
                color = Color.GREEN;
                break;
            case YELLOW:
                color = Color.RED;
                break;
            case GREEN:
                color = Color.YELLOW;
                break;
        }
    }
}
