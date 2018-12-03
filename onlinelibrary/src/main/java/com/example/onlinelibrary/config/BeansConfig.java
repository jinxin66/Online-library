package com.example.onlinelibrary.config;

import flybear.hziee.core.base.ExceptionHandler;
import flybear.hziee.core.util.SpringContextUtil;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeansConfig {

	@Bean
	public SpringContextUtil springContextUtil(){
		System.out.println("springContextUtil....");
		return new SpringContextUtil();
	}
	
	@Bean
	public ExceptionHandler exceptionHandler(){
		System.out.println("ExceptionHandler.....");
		return new ExceptionHandler();
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1800);//单位为S
			}
		};
	}
}
