package test.zoe.xmlRes.AreaErpDistributionConf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/24
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
public interface OtcStoresConfParse {

    /**
     * 通过地区编号获取地区-审核人-配送中心配置
     * @param areaId
     * @return
     * */
    public Area getAreaById(String areaId);

    /**
     * 获取所有有效yn=1的地区信息
     * @param
     * @return
     * */
    public List<Area> getAreasAll();

    /**
     * 通过一级审核人erp获取地区信息
     * @param erpCode
     * @return
     * */
    public List<Area> getAreasByAuditorLevelOne(String erpCode);

    /**
     * 通过二级审核人erp获取地区信息
     * @param erpCode
     * @return
     * */
    public List<Area> getAreasByAuditorLevelTwo(String erpCode);

    /**
     * 通过一级审核人erp获取配送中心信息
     * @param erpCode
     * @return
     * */
    public List<Distribution> getDistributionsByAuditorLevelOne(String erpCode);

    /**
     * 通过二级审核人erp获取配送中心信息
     * @param erpCode
     * @return
     * */
    public List<Distribution> getDistributionsByAuditorLevelTwo(String erpCode);
}
