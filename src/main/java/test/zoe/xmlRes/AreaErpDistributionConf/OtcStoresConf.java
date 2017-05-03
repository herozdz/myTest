package test.zoe.xmlRes.AreaErpDistributionConf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/24
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 * otc医药多仓配置信息
 */
public class OtcStoresConf {

    /**
     * 地区-审核人-配送中心映射配置
     * */
    private List<Area> areas;

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OtcStoresConf{");
        sb.append("areas=").append(areas);
        sb.append('}');
        return sb.toString();
    }
}
