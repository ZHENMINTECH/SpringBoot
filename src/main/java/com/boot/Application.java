package com.boot;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
public class Application implements EmbeddedServletContainerCustomizer
{
	@RequestMapping("/")
	public String home(){
		
		return "hellow";
	}
	
	@RequestMapping("/time")
	public Object showTime(){
		 return "现在时间：" + (new Date()).toLocaleString();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		
		container.setPort(1010);
		
	}
}
