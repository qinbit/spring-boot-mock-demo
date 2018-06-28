package com.pnshsh;

import com.pnshsh.service.RestServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(RestServiceImpl.class)
public class RestTest {

    @Autowired
    private RestServiceImpl restService;

    @Autowired
    private MockRestServiceServer server;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void test1() {
        server.expect(requestTo("http://localhost:8081/hello")).andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));
        String greeting =restService.query();
        Assert.assertEquals("hello", greeting);
    }
}
