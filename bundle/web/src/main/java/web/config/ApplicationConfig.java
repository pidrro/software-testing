package web.config;

import hu.uni.miskolc.iit.swtest.team3.controller.ReaderController;
import hu.uni.miskolc.iit.swtest.team3.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan
@Configuration
public class ApplicationConfig {

    @Autowired ReaderService readerService;

    @Bean
    public ReaderController readerController() {
        return new ReaderController(readerService);
    }
}
