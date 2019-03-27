package boot.test.boot;

import boot.test.annotation.EnableZdzConfig;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@EnableZdzConfig
//@ConditionalOnProperty(prefix = "laf.config.manager", name = "enable", havingValue = "true", matchIfMissing = true)
public class ZdzConfigConfiguration {

}
