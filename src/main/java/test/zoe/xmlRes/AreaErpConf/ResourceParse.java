package test.zoe.xmlRes.AreaErpConf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/22
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 * 配置解析接口
 */
public interface ResourceParse {

    /**
     * 通过一级审核人erp查找配置行（扩展考虑多行）
     * @param auditor1
     * @return
     */
    public List<AreaErpConfRow> getAreaErpConfByAuditorLevelOne(String auditor1);

    /**
     * 通过二级审核人erp查找配置行（扩展考虑多行）
     * @param auditor2
     * @return
     */
    public List<AreaErpConfRow> getAreaErpConfByAuditorLevelTwo(String auditor2);

    /**
     * 通过地区id查找配置行（单行）
     * @param areaId
     * @return
     */
    public AreaErpConfRow getAreaErpConfByAreaId(String areaId);
}
