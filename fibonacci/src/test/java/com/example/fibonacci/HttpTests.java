package com.example.fibonacci;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/fibon?number=10",
                String.class)).contains("34");
    }

    @Test
    public void ReturnEmpty() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/fibon?number=",
                String.class)).contains("Incorrect param");
    }

    @Test
    public void ReturnBadWord() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/fibon?namber=4",
                String.class)).contains("Incorrect param");
    }
    @Test
    public void ReturnNegativeNumber() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/fibon?number=-4",
                String.class)).contains("Incorrect param");
    }
}
