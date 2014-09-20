package com.walmart.delivery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration class for SpringWebMvc
 *  
 * @author josemanzoli
 * @since 2014-09-20
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.walmart.delivery") 
public class WebMvcConfig {

}
