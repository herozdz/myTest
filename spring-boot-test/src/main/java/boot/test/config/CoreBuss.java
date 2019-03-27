package boot.test.config;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 19-3-27
 * Time: 下午2:33
 * To change this template use File | Settings | File Templates.
 */
public class CoreBuss {

    private String col;

    public CoreBuss(String col) {
        this.col = col;
    }

    public CoreBuss() {
        System.out.println("CoreBuss class is init.");
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CoreBuss{");
        sb.append("col='").append(col).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
