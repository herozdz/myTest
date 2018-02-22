package test.zoe.maptest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/2/12
 * Time: 9:58
 * To change this template use File | Settings | File Templates.
 */
public class Element {

    private int index;

    private String eVale;


    @Override
    public int hashCode() {
        /**
         * 将 eVale = 123456abc字符串对应的值
         * 123-->eVale.hashCode()
         * 345-->eVale.hashCode()
        */
        return eVale.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Element o = (Element) obj;
        if(this.getIndex() == o.getIndex() && this.hashCode() == o.hashCode()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Element{");
        sb.append("index=").append(index);
        sb.append(", eVale='").append(eVale).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String geteVale() {
        return eVale;
    }

    public void seteVale(String eVale) {
        this.eVale = eVale;
    }
}
