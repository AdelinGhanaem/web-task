package com.cayetano.core;

import com.cayetano.persistense.PersistenceConfigurations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.cayetano.core")
@Import({PersistenceConfigurations.class})
public class CoreConfigurations {

}
