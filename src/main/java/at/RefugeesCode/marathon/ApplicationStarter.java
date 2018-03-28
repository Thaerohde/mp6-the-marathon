package at.RefugeesCode.marathon;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class ApplicationStarter {
    @Bean
    ApplicationRunner start(RestTemplate restTemplate, RunnerGenerator runnerGenerator){
        return args->{
            String url ="http://localhost:8080/runners";
            List<Runner> runners = runnerGenerator.getrunners();
            runners.stream()
                    .peek(runner -> System.out.println("runner"))
                    .forEach(postRunner(restTemplate, url));
        };

    }

    private Consumer<Runner> postRunner(RestTemplate restTemplate, String url) {
        return runner ->  restTemplate.postForEntity(url,runner, Runner.class);
    }

}
