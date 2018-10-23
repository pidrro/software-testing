package web.config;

import hu.uni.miskolc.iit.swtest.team3.service.DummyReaderServiceImpl;
import hu.uni.miskolc.iit.swtest.team3.service.ReaderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfig {

    @Bean
    public ReaderService readerService() {
        return new DummyReaderServiceImpl();
    }
}
