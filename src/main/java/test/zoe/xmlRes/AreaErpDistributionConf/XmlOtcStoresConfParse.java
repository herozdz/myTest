package test.zoe.xmlRes.AreaErpDistributionConf;

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
public class XmlOtcStoresConfParse implements OtcStoresConfParse {

    private OtcStoresConf otcStoresConf;

    public XmlOtcStoresConfParse(Resource path) throws Exception {
        this.otcStoresConf = parseResource(path);
    }

    public OtcStoresConf parseResource(Resource path) throws Exception {
        XStream xStream = new XStream();
        xStream.alias("areas", OtcStoresConf.class);
        xStream.alias("area", Area.class);
        xStream.useAttributeFor(Area.class, "areaId");
        xStream.useAttributeFor(Area.class, "areaName");
        xStream.useAttributeFor(Area.class, "yn");

        xStream.alias("auditor", Auditor.class);
        xStream.useAttributeFor(Auditor.class, "erpCode");
        xStream.useAttributeFor(Auditor.class, "yn");

        xStream.alias("distribution", Distribution.class);
        xStream.useAttributeFor(Distribution.class, "id");
        xStream.useAttributeFor(Distribution.class, "name");
        xStream.useAttributeFor(Distribution.class, "storeId");
        xStream.useAttributeFor(Distribution.class, "storeName");
        xStream.useAttributeFor(Distribution.class, "yn");

        xStream.addImplicitCollection(OtcStoresConf.class, "areas");

        String xml = IOUtils.toString(path.getInputStream());
        OtcStoresConf otcStoresConf = (OtcStoresConf) xStream.fromXML(xml);
        return otcStoresConf;
    }

    public Area getAreaById(String areaId) {
        List<Area> areas = otcStoresConf.getAreas();
        for(Area area:areas){
            if(1==area.getYn() && areaId.equals(area.getAreaId())){
                return area;
            }
        }
        return null;
    }

    public List<Area> getAreasAll() {
        List<Area> areas = otcStoresConf.getAreas();
        List<Area> areasRes = new ArrayList<Area>();
        for(Area area:areas){
            if(1==area.getYn()){
                areasRes.add(area);
            }
        }
        return areasRes;
    }

    public List<Area> getAreasByAuditorLevelOne(String erpCode) {
        List<Area> areas = otcStoresConf.getAreas();
        List<Area> areasRes = new ArrayList<Area>();
        for(Area area:areas){
            if(1==area.getYn()){
                List<Auditor> auditors = area.getAuditor1();
                for(Auditor auditor:auditors){
                    if(1 == auditor.getYn() && erpCode.equals(auditor.getErpCode())){
                        areasRes.add(area);
                        break;
                    }
                }
            }
        }
        return areasRes;
    }

    public List<Area> getAreasByAuditorLevelTwo(String erpCode) {
        List<Area> areas = otcStoresConf.getAreas();
        List<Area> areasRes = new ArrayList<Area>();
        for(Area area:areas){
            if(1==area.getYn()){
                List<Auditor> auditors = area.getAuditor2();
                for(Auditor auditor:auditors){
                    if(1 == auditor.getYn() && erpCode.equals(auditor.getErpCode())){
                        areasRes.add(area);
                        break;
                    }
                }
            }
        }
        return areasRes;
    }

    public List<Distribution> getDistributionsByAuditorLevelOne(String erpCode) {
        List<Area> areas = otcStoresConf.getAreas();
        List<Distribution> distributions = new ArrayList<Distribution>();
        for(Area area:areas){
            if(1==area.getYn()){
                List<Auditor> auditors = area.getAuditor1();
                for(Auditor auditor:auditors){
                    if(1 == auditor.getYn() && erpCode.equals(auditor.getErpCode())){
                        List<Distribution> distributions1 = area.getDistributions();
                        for(Distribution distribution:distributions1){
                            if(1 == distribution.getYn()){
                                distributions.add(distribution);
                            }
                        }
                        break;
                    }
                }
            }
        }
        return distributions;
    }

    public List<Distribution> getDistributionsByAuditorLevelTwo(String erpCode) {
        List<Area> areas = otcStoresConf.getAreas();
        List<Distribution> distributions = new ArrayList<Distribution>();
        for(Area area:areas){
            if(1==area.getYn()){
                List<Auditor> auditors = area.getAuditor2();
                for(Auditor auditor:auditors){
                    if(1 == auditor.getYn() && erpCode.equals(auditor.getErpCode())){
                        List<Distribution> distributions1 = area.getDistributions();
                        for(Distribution distribution:distributions1){
                            if(1 == distribution.getYn()){
                                distributions.add(distribution);
                            }
                        }
                        break;
                    }
                }
            }
        }
        return distributions;
    }

    public OtcStoresConf getOtcStoresConf() {
        return otcStoresConf;
    }

    public void setOtcStoresConf(OtcStoresConf otcStoresConf) {
        this.otcStoresConf = otcStoresConf;
    }
}
