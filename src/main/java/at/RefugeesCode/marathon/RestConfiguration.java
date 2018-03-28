package at.RefugeesCode.marathon;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration

public class RestConfiguration {
    @Bean
    RestTemplate restTamplate (){
        return new RestTemplate();
    }

}
