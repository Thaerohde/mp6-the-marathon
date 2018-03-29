package at.RefugeesCode.marathon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class RunnerEndpointTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @SpyBean
    private RunnerEndpoint runnerEndpoint;
    private String endpoint = "/test";

    private String url;

    @BeforeEach
    void before() {
        url = "http://localhost:" + port + endpoint;
    }



    @Test
    void post() {
        ResponseEntity<String[]> response = testRestTemplate
                .getForEntity(url, String[].class);
    }

    @Test
    void getAll() {
    }

    @Test
    void getwinner() {
    }
}