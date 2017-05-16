package TestCommonValueInject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.zoe.commonValueInject.VcConstantUtils;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/5/15
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-config-bean.xml"})
//@ActiveProfiles(profiles = "test")
public class Test {
    @Resource
    private VcConstantUtils vcConstantUtils;

    @org.junit.Test
    public void testA(){
        System.out.println(vcConstantUtils.getConstantMap());
    }
}
