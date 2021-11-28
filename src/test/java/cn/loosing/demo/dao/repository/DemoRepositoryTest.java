package cn.loosing.demo.dao.repository;

import cn.loosing.demo.dao.entity.Demo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoRepositoryTest {

    @Autowired
    private DemoRepository demoRepository;

    @Test
    void findAllByNameContaining() {


        demoRepository.save(new Demo().setName("A"));
        demoRepository.save(new Demo().setName("B"));
        demoRepository.save(new Demo().setName("A"));
        String name = "A";
        List<Demo> allByNameContaining = demoRepository.findAllByNameContaining(name);
        Assert.isTrue(allByNameContaining.size()>1,"A");
    }

    @Test
    void findFirstByNameEqualsOrderByCreatedAtDesc() {
        Optional<Demo> demo = demoRepository.findFirstByNameEqualsOrderByCreatedAtDesc("A");
        List<Demo> as = demoRepository.findFirst10ByNameEqualsOrderByCreatedAtDesc("A");
        System.out.println(demo);
        System.out.println(as);
    }
}