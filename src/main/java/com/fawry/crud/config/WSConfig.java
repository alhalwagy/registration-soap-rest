package com.fawry.crud.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WSConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/service/*");
    }

    @Bean(name = "bkRegistrationWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bkRegistrationSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("bkRegistrationPort");
        wsdl11Definition.setLocationUri("/service/bkRegistration-details");
        wsdl11Definition.setTargetNamespace("http://fawry.com/crud/bkregistration");
        wsdl11Definition.setSchema(bkRegistrationSchema);
        return wsdl11Definition;
    }


    @Bean
    public XsdSchema bkRegistrationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/bkRegistration.xml"));
    }
}