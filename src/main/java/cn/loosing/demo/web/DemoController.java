package cn.loosing.demo.web;

import cn.loosing.demo.dao.entity.Demo;
import cn.loosing.demo.dao.repository.DemoRepository;
import cn.loosing.demo.service.DemoService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoRepository demoRepository;
    private final DemoService demoService;
    public DemoController(DemoRepository demoRepository, DemoService demoService) {
        this.demoRepository = demoRepository;
        this.demoService = demoService;
    }


    @GetMapping("all")
    public List<Demo> getDemoList() {
        return demoRepository.findAll(Sort.by(Sort.Order.desc("createdAt")));
    }
}
