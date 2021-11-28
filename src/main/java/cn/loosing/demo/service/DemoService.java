package cn.loosing.demo.service;

import cn.loosing.demo.dao.entity.Demo;
import cn.loosing.demo.dao.repository.DemoRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public Demo getDemo(String name) {
        Demo demo = demoRepository.findFirstByNameEqualsOrderByCreatedAtDesc(name).get();
        return demo;
    }

}
