package com.pnshsh;

import com.pnshsh.service.HelloServiceImpl;
import com.pnshsh.service.InnerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelleServiceTest {

    @InjectMocks
    @Autowired
    HelloServiceImpl helloService;

    @Mock
    InnerServiceImpl innerService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * when...thenReturn
     * 当满足条件的时候返回mock结果，否则返回默认值
     */
    @Test
    public void test1() {
        Mockito.when(innerService.isLove("qinyuan")).thenReturn(true);
        Assert.assertEquals("cool my love", helloService.hello("qinyuan"));
        Assert.assertEquals("handsome", helloService.hello("pnshsh"));
        Assert.assertNull(innerService.whoAreU());
    }

    /**
     * doCallRealMethod...when...
     * 当条件满足的时候执行方法实际逻辑，否则返回默认值
     */
    @Test
    public void test2() {
        Mockito.doCallRealMethod().when(innerService).isLove("qinyuan");
        Assert.assertEquals("cool", helloService.hello("qinyuan"));
        Assert.assertEquals("handsome", helloService.hello("pnshsh"));
        Assert.assertNull(innerService.whoAreU());
    }

}
