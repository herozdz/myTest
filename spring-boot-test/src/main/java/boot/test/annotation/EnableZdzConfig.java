package boot.test.annotation;

import boot.test.config.ZdzDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ZdzDefinitionRegistrar.class)
public @interface EnableZdzConfig {
}
