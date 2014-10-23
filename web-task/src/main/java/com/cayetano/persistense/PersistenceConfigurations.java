package com.cayetano.persistense;

import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.cayetano.persistense")
public class PersistenceConfigurations {

    @Bean
    public DataSource dataSource(){

        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        source.setUrl("jdbc:hsqldb:mem:testdb");
        source.setUsername("sa");
        source.setPassword("");
        return source;
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean annotationSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setAnnotatedClasses(ClientConnectionEntity.class);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }





    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.put("hibernate.current_session_context_class", "thread");
        properties.put("hibernate.show_sql",false);
        properties.put("hibernate.hbm2ddl.auto","create");
        return properties;

    }

}
