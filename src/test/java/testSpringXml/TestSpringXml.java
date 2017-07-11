package testSpringXml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.zoe.springXmlTest.Facade;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/11
 * Time: 9:39
 * To change this template use File | Settings | File Templates.
 */
public class TestSpringXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-config-bean.xml");

        Facade facade = (Facade) context.getBean("abcd");
        System.out.println(facade.getId());
        System.out.println(facade.getInterCode());
        System.out.println(facade.getReqEvent());
        System.out.println(facade.getResEvent());
    }
}
