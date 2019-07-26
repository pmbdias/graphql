package br.gov.mg.fazenda.graphqlweb.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableWebMvc
@ComponentScan(basePackages = {"br.gov.mg.fazenda.graphqlweb", "br.gov.mg.fazenda.graphqlejb"})
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }

}