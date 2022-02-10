package tiagoDev.cobranca;

import java.util.Locale;
import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaApplication.class, args);
	}
        
        @Bean
        public FixedLocaleResolver localeResolver(){
            return new FixedLocaleResolver(new Locale("pt", "BR"));
        }
        
        @Configuration
        public static class MvConfig extends WebMvcConfigurerAdapter{
            
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addRedirectViewController("/", "/titulos");
            }
            
        }
        
}
