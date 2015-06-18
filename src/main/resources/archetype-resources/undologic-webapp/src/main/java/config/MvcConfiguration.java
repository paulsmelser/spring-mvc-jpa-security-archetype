#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import ${package}.service.CalAmpUdpListener;
import ${package}.service.CalAmpUdpListenerBuilder;
import ${package}.service.UdpListener;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="${package}.controller")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
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

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);

	}



	@Bean(name = "calAmpUdpListenerBuilder")
	public UdpListener udpLisiter(){
		CalAmpUdpListener listener =  CalAmpUdpListenerBuilder.initalize()
				.setMaxClients(1)
				.setPathfProcess("/")
				.setPort(1810)
				.build();
		listener.run();
		return listener;
	}



//	@Bean
//	public MessageSource messageSource() {
//
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasenames("classpath:messages/messages",
//				"classpath:messages/validation");
//		// if true, the key of the message will be displayed if the key is not
//		// found, instead of throwing a NoSuchMessageException
//		messageSource.setUseCodeAsDefaultMessage(true);
//		messageSource.setDefaultEncoding("UTF-8");
//		// ${symbol_pound} -1 : never reload, 0 always reload
//		messageSource.setCacheSeconds(0);
//		return messageSource;
//	}
}
