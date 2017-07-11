package test.zoe.springXmlTest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/10
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


public class LiNamespaceHandler extends NamespaceHandlerSupport {

    public void init()
    {
        registerBeanDefinitionParser("facade", new FacadeParser());
    }

}