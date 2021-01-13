package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"model" , "aop"})
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class ApplicationContext {
}
