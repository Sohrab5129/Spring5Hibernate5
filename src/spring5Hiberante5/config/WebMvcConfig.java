package spring5Hiberante5.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import spring5Hiberante5.validator.UserAccountValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "spring5Hiberante5" })
public class WebMvcConfig implements WebMvcConfigurer {
	
	AuthenticationInterceptor getAuth() {
		return new AuthenticationInterceptor();
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getAuth());
	}
	
	/* Create a MessageSource bean to show message from message files, for i18n purpose. */
   
	@Bean(name = "messageSource")
    public MessageSource getMessageSource() {
		
        ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
      
      /* Set the base name for the messages and validator errors properties file. 
         All the messages.perperties file are saved in src/main/resources/config folder
         While all validate errors message are saved in src/main/resources/config/errors.properties file. */
        
        ret.setBasenames("classpath:config/messages","classpath:config/errors");
        ret.setCacheSeconds(1);
        ret.setUseCodeAsDefaultMessage(true);
        ret.setDefaultEncoding("utf-8");
        return ret;
    }
	
	/* LocalValidatorFactoryBean will validate annotated DTO's properties by the property annotation automatically. */
    @Bean(name="validator")
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }
    
    /* This is the custom user account validator bean. */
//    @Bean(name="customUserAccountValidator")
//    public Validator customUserAccountValidator(){
//        return new UserAccountValidator();
//    }
}