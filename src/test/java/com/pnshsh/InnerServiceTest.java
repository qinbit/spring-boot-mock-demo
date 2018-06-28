package com.pnshsh;

import com.pnshsh.service.InnerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InnerServiceTest {

    @Autowired
    InnerService innerService;

    @Test
    public void testIsLove() {
        boolean islove = innerService.isLove("pnshsh");
        Assert.assertTrue(islove);
    }
}
