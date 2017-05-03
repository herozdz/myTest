package test.zoe.xmlRes.AreaErpConf;

import com.thoughtworks.xstream.XStream;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/22
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 * xml文件解析器
 */
public class XMLResourceParse implements ResourceParse {

    private AreaErpConf areaErpConf;

    public XMLResourceParse(Resource path) throws Exception {
        this.areaErpConf = parseResource(path);
    }

    public AreaErpConf parseResource(Resource path) throws Exception {
        XStream xStream = new XStream();
        xStream.alias("areas", AreaErpConf.class);
        xStream.alias("area", AreaErpConfRow.class);
        xStream.useAttributeFor(AreaErpConfRow.class, "areaId");
        xStream.useAttributeFor(AreaErpConfRow.class, "areaName");
        xStream.useAttributeFor(AreaErpConfRow.class, "auditor1");
        xStream.useAttributeFor(AreaErpConfRow.class, "auditor2");
        xStream.useAttributeFor(AreaErpConfRow.class, "yn");

        xStream.addImplicitCollection(AreaErpConf.class, "areas");

        String xml = IOUtils.toString(path.getInputStream());
        AreaErpConf areaErpConf = (AreaErpConf) xStream.fromXML(xml);
        return areaErpConf;
    }

    public List<AreaErpConfRow> getAreaErpConfByAuditorLevelOne(String auditor1) {
        List<AreaErpConfRow> areaErpConfRows = areaErpConf.getAreas();
        List<AreaErpConfRow> areas = new ArrayList<AreaErpConfRow>();
        for(AreaErpConfRow areaErpConfRow:areaErpConfRows){
            if(auditor1.equals(areaErpConfRow.getAuditor1()) && 1 == areaErpConfRow.getYn()){
                areas.add(areaErpConfRow);
            }
        }
        return areas;
    }

    public List<AreaErpConfRow> getAreaErpConfByAuditorLevelTwo(String auditor2) {
        List<AreaErpConfRow> areaErpConfRows = areaErpConf.getAreas();
        List<AreaErpConfRow> areas = new ArrayList<AreaErpConfRow>();
        for(AreaErpConfRow areaErpConfRow:areaErpConfRows){
            if(auditor2.equals(areaErpConfRow.getAuditor2()) && 1 == areaErpConfRow.getYn()){
                areas.add(areaErpConfRow);
            }
        }
        return areas;
    }

    public AreaErpConfRow getAreaErpConfByAreaId(String areaId) {
        List<AreaErpConfRow> areaErpConfRows = areaErpConf.getAreas();
        for(AreaErpConfRow areaErpConfRow:areaErpConfRows){
            if(areaId.equals(areaErpConfRow.getAreaId()) && 1 == areaErpConfRow.getYn()){
                return areaErpConfRow;
            }
        }
        return null;
    }

    public AreaErpConf getAreaErpConf() {
        return areaErpConf;
    }

    public void setAreaErpConf(AreaErpConf areaErpConf) {
        this.areaErpConf = areaErpConf;
    }
}
