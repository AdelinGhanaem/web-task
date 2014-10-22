package com.cayetano.core;

import com.cayetano.persistense.PersistenceConfigurations;
import com.cayetano.persistense.UserConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.cayetano.core")
@Import({PersistenceConfigurations.class})
public class CoreConfigurations {

}
