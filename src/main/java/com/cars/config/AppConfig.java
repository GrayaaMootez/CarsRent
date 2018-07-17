package com.cars.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cars.i18.UrlLocaleInterceptor;
import com.cars.i18.UrlLocaleResolver;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	// classpath des fichiers .properties
	@Bean(name = "messageSource")
	public MessageSource getMessageResource() {
		ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();

		// Read i18n/messages_xxx.properties file.
		// For example: i18n/messages_en.properties
		messageResource.setBasename("classpath:i18n/messages");
		messageResource.setDefaultEncoding("UTF-8");
		return messageResource;
	}

	// messages pour les validations
	@Bean
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(getMessageResource());
		return bean;
	}

	// pour utuliser l'annotation @value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// To solver URL like:
	// /SomeContextPath/en/login2
	// /SomeContextPath/fr/login2
	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver() {
		LocaleResolver resolver = new UrlLocaleResolver();
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();

		registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*");
	}

}
