package test.zoe.xmlRes.AreaErpConf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/22
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 * 医药多仓项目，地区&审核人员映射关系
 */
public class AreaErpConf {

    List<AreaErpConfRow> areas;

    public List<AreaErpConfRow> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaErpConfRow> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "AreaErpConf{" +
                "areas=" + areas +
                '}';
    }
}
