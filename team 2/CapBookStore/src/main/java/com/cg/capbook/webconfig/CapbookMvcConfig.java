package com.cg.capbook.webconfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class CapbookMvcConfig implements WebMvcConfigurer{
	@Override
	public Validator getValidator() {
		return new LocalValidatorFactoryBean();
	}	    
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry){ 
	            registry.addResourceHandler("/resources/**")
	                 .addResourceLocations("classpath:/static/");
	    }
	    
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver ref = new InternalResourceViewResolver();
		ref.setPrefix("/views/");
		ref.setSuffix(".jsp");
		return ref;
	}
	
	@Bean
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		System.out.println(messageSource.getBasenameSet());
		return messageSource;
	}
}
