package m.s.h.blog_eureka_client.config;

import m.s.h.common.DbInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.image.DataBuffer;
import java.util.Properties;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = {"m.s.h.blog_eureka_client.repository", "com.intermind.kr.admin.repository"}, entityManagerFactoryRef = "jpaEntityManagerFactory", transactionManagerRef = "jpaTransactionManager")
public class JpaConfiguration {

    @Bean(name = "jpsDataSource")
    public DriverManagerDataSource jpsDataSource(){
        DbInfo dbInfo = new DbInfo();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl(dbInfo.getDatabase_url());
        dataSource.setUsername("root");
        dataSource.setPassword(dbInfo.getDatabase_password());

        dbInfo = null;
        return dataSource;
    }

    @Bean(name = "jpaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(jpsDataSource());
        em.setPackagesToScan(new String[] {"com.intermind.kr.model"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean(name = "jpaTransactionManager")
    public PlatformTransactionManager jpaTransactionManager(
            EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

}