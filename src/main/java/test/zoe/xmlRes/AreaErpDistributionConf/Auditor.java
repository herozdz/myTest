package test.zoe.xmlRes.AreaErpDistributionConf;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/24
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 * 审核人实体
 */
public class Auditor {

    /**
     * erp
     * */
    private String erpCode;

    /**
     * 1:有效，0：无效
     * */
    private Integer yn;

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auditor{");
        sb.append("erpCode='").append(erpCode).append('\'');
        sb.append(", yn=").append(yn);
        sb.append('}');
        return sb.toString();
    }
}
