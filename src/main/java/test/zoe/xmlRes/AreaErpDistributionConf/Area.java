package test.zoe.xmlRes.AreaErpDistributionConf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/24
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 * 地区实体
 */
public class Area {

    /**
     * 地区编号
     * */
    private String areaId;

    /**
     * 地区名称
     * */
    private String areaName;

    /**
     * 一级审核人
     * */
    private List<Auditor> auditor1;

    /**
     * 二级审核人
     * */
    private List<Auditor> auditor2;

    /**
     * 配送中心信息
     * */
    private List<Distribution> distributions;

    /**
     * 1:有效，0：无效
     * */
    private Integer yn;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<Auditor> getAuditor1() {
        return auditor1;
    }

    public void setAuditor1(List<Auditor> auditor1) {
        this.auditor1 = auditor1;
    }

    public List<Auditor> getAuditor2() {
        return auditor2;
    }

    public void setAuditor2(List<Auditor> auditor2) {
        this.auditor2 = auditor2;
    }

    public List<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<Distribution> distributions) {
        this.distributions = distributions;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Area{");
        sb.append("areaId='").append(areaId).append('\'');
        sb.append(", areaName='").append(areaName).append('\'');
        sb.append(", auditor1=").append(auditor1);
        sb.append(", auditor2=").append(auditor2);
        sb.append(", distributions=").append(distributions);
        sb.append(", yn=").append(yn);
        sb.append('}');
        return sb.toString();
    }
}
