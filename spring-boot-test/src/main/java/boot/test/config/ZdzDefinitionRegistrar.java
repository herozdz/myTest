package boot.test.config;

import boot.test.annotation.EnableZdzConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.concurrent.atomic.AtomicBoolean;

import static boot.test.constants.Constants.SINGLETON;
import static boot.test.constants.Constants.START;
import static boot.test.constants.Constants.STOP;

/**

 */
public class ZdzDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private ConfigurableEnvironment environment;

    private AtomicBoolean registered = new AtomicBoolean(false);

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public void registerBeanDefinitions(final AnnotationMetadata metadata, final BeanDefinitionRegistry registry) {
        System.out.println("ZdzDefinitionRegistrar init...");
        if (metadata.hasAnnotation(EnableZdzConfig.class.getName())) {
            if (registered.compareAndSet(false, true)) {
                System.out.println("ZdzDefinitionRegistrar.EnableZdzConfig init...");
                BeanDefinition coreBean =  this.createManagerDefinition(environment);
                /**创建bean，并加入到aplicationContext中去（Map）*/
                registry.registerBeanDefinition("coreBean",coreBean);
            }
        }
    }


    /**
     * 创建配置管理器定义
     *
     * @param environment
     * @return
     */
    protected RootBeanDefinition createManagerDefinition(final ConfigurableEnvironment environment) {
        RootBeanDefinition definition = new RootBeanDefinition();
        definition.setBeanClass(CoreBuss.class);
        definition.setLazyInit(false);
        definition.setScope(SINGLETON);
        //definition.setInitMethodName(START);
       // definition.setDestroyMethodName(STOP);
        /*addProperty(definition, environment, KEY_MANAGER_APPLICATION, APPLICATION);
        addProperty(definition, environment, KEY_MANAGER_PATH, PATH);
        addProperty(definition, environment, KEY_MANAGER_THREADS, THREADS);

        //添加parmeters配置
        ManagedMap<String, Object> params = new ManagedMap<String, Object>();
        for (int i = 0; ; i++) {
            if (!addParameter(params, i, environment)) {
                break;
            }
        }
        if (!params.isEmpty()) {
            definition.getPropertyValues().add(PARAMETERS, params);
        }
        //添加resources配置
        ManagedList<Resource> list = new ManagedList<Resource>();
        //配置在laf.config.manager.resource上
        //配置在laf.config.manager.resources[0]上
        if (!addResource(list, KEY_MANAGER_RESOURCE, environment)) {
            for (int i = 0; ; i++) {
                if (!addResource(list, KEY_MANAGER_RESOURCES + "[" + i + "]", environment)) {
                    break;
                }
            }
        }*/
        //definition.getConstructorArgumentValues().addIndexedArgumentValue(0, list);
        return definition;
    }

}
