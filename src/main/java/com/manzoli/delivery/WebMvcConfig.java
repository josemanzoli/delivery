package com.manzoli.delivery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration class for SpringWebMvc
 *  
 * @author josemanzoli
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.manzoli.delivery") 
public class WebMvcConfig {

}
