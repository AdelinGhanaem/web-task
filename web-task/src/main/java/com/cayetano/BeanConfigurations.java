package com.cayetano;

import com.cayetano.core.CoreConfigurations;
import com.cayetano.persistense.PersistenceConfigurations;
import com.cayetano.web.WebConfigurations;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This class contains main module configurations
 * Created by adelin.ghanayem@gmail.com
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@Import({CoreConfigurations.class,PersistenceConfigurations.class,WebConfigurations.class})
public class BeanConfigurations {

}
