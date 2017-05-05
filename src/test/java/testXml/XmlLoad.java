package testXml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.zoe.xmlRes.AreaErpDistributionConf.XmlOtcStoresConfParse;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/3/9
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
public class XmlLoad {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext pathXml=  new ClassPathXmlApplicationContext("classpath:spring/spring-config-bean.xml");
        XmlOtcStoresConfParse xmlOtcStoresConfParse = (XmlOtcStoresConfParse)pathXml.getBean("xmlOtcStoresConfParse");

        System.out.println("xmlOtcStoresConfParse.getAreasAll->"+ xmlOtcStoresConfParse.getAreasAll());
         //System.out.println(xmlOtcStoresConfParse.getAreaById("1"));
        //System.out.println(xmlOtcStoresConfParse.getDistributionsByAuditorLevelOne("bjwht"));
        //System.out.println(xmlOtcStoresConfParse.getDistributionsByAuditorLevelTwo("bjwht"));
        //System.out.println(xmlOtcStoresConfParse.getAreasByAuditorLevelOne("bjwht"));
        //System.out.println(xmlOtcStoresConfParse.getAreasByAuditorLevelTwo("zoudezhu"));


        //System.out.println("xmlOtcStoresConfParse:-->"+xmlOtcStoresConfParse.getOtcStoresConf());
/*
        System.out.println("**************************");
        ResourceParse resourceParse = (ResourceParse)pathXml.getBean("resourceParse");
        System.out.println(resourceParse);
        FlowDefain flowDefain = resourceParse.getFlowDefain("mss_record_flow");
        FlowNode flowNode = resourceParse.getFlowNode("mss_record_flow","mss_record_saler");
        System.out.println(flowDefain);
        System.out.println(flowNode);

        System.out.println("---------------------------------");
        test.zoe.xmlRes.AreaErpConf.XMLResourceParse  xmlResourceParse = (test.zoe.xmlRes.AreaErpConf.XMLResourceParse )pathXml.getBean("xmlResourceParse");
        System.out.println("xmlResourceParse.getAreaErpConf:"+xmlResourceParse.getAreaErpConf());
        System.out.println("xmlResourceParse.getAreaErpConfByAreaId:"+xmlResourceParse.getAreaErpConfByAreaId("1"));
        System.out.println("xmlResourceParse.getAreaErpConfByAuditorLevelOne:"+xmlResourceParse.getAreaErpConfByAuditorLevelOne("zoudezhu"));
        System.out.println("xmlResourceParse.getAreaErpConfByAuditorLevelTwo:"+xmlResourceParse.getAreaErpConfByAuditorLevelTwo("zoudezhu"));*/
    }
}
