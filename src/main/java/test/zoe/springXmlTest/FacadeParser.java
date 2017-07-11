package test.zoe.springXmlTest;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/7/10
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class FacadeParser extends AbstractSimpleBeanDefinitionParser {

    @Override
    protected Class<Facade> getBeanClass(Element element) {
        return Facade.class;
    }

    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        try
        {
            builder.addPropertyValue("id", element.getAttribute("id"));
            builder.addPropertyValue("interCode", element.getAttribute("interCode"));
            builder.addPropertyValue("reqEvent",  element.getAttribute("reqEvent"));

            builder.addPropertyValue("resEvent", element.getAttribute("resEvent"));

        } catch (Exception e) {
            parserContext.getReaderContext().error("class " + FacadeParser.class.getName() + " can not be create", element, null, e);
        }
    }
}