package cn.loosing.demo.service;

import cn.loosing.demo.dao.entity.Demo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoServiceTest {

    @Autowired
    private DemoService demoService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDemo() {
        demoService.getDemo("sss");
    }

    @Test
    void saveDemo() {
        Demo demo = demoService.saveDemo(new Demo().setName("A").setDescription("aaaa"));
        Assert.hasLength(demo.getId(),"aa");

    }
}