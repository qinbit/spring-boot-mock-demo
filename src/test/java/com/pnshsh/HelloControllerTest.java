package com.pnshsh;

import com.pnshsh.controller.HelloController;
import com.pnshsh.service.HelloService;
import com.pnshsh.service.HelloServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
@RunWith(SpringRunner.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloServiceImpl helloService;

    @Test
    public void testHello() throws Exception {
        given(helloService.hello("pnshsh")).willReturn("handsome pnshsh");

        mvc.perform(MockMvcRequestBuilders.request( HttpMethod.GET,"/hello?name=pnshsh"))
                .andExpect(status().isOk()).andExpect(content().string("handsome pnshsh"));
    }
}
