package test.zoe.xmlRes.AreaErpConf;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/22
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 * 医药多仓项目，地区&审核人员映射关系行
 */
public class AreaErpConfRow {

    /**
     * 地区编号
     * */
    private String areaId;

    /**
     * 地区名称
     * */
    private String areaName;

    /**
     * 地区一级审核人员erp
     * */
    private String auditor1;

    /**
     * 地区二级审核人员erp
     * */
    private String auditor2;

    /**
     * 有效，无效：1,0
     * */
    private Integer yn;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAuditor1() {
        return auditor1;
    }

    public void setAuditor1(String auditor1) {
        this.auditor1 = auditor1;
    }

    public String getAuditor2() {
        return auditor2;
    }

    public void setAuditor2(String auditor2) {
        this.auditor2 = auditor2;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "AreaErpConfRow{" +
                "areaId='" + areaId + '\'' +
                "areaName='" + areaName + '\'' +
                ", auditor1='" + auditor1 + '\'' +
                ", auditor2='" + auditor2 + '\'' +
                ", yn='" + yn + '\'' +
                '}';
    }
}
