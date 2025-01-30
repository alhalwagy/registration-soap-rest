package com.fawry.crud.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.fawry.crud.repository.EBPPConfigurationDAO",
        entityManagerFactoryRef = "configurationEntityManagerFactory",
        transactionManagerRef = "configurationTransactionManager"
)
public class EBPPConfigurationConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.ebppconfiguration")
    public DataSourceProperties configurationDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource configurationDataSource() {
        return configurationDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

  @Bean
  public LocalContainerEntityManagerFactoryBean configurationEntityManagerFactory() {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(configurationDataSource());
        emf.setPackagesToScan("com.fawry.crud.entity.EBPP_CONFIGURATION");

      // Set the JPA Vendor Adapter
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // You can use other adapters if needed
      emf.setJpaVendorAdapter(vendorAdapter);

      return emf;


  }

    @Bean
    public PlatformTransactionManager configurationTransactionManager() {

        EntityManagerFactory emf = configurationEntityManagerFactory().getObject();
        return new JpaTransactionManager(emf);
    }


}