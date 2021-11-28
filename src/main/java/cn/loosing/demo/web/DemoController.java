package cn.loosing.demo.web;

import cn.loosing.demo.dao.entity.Demo;
import cn.loosing.demo.dao.repository.DemoRepository;
import cn.loosing.demo.doman.PageRequest;
import cn.loosing.demo.service.DemoService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<List<Demo>> getDemoList() {
        return ResponseEntity.ok(demoRepository.findAll(Sort.by(Sort.Order.desc("createdAt"))));
    }

    @PostMapping("page")
    public ResponseEntity<Page<Demo>> page(PageRequest pageRequest, Demo demo) {
        System.out.println(pageRequest);
        System.out.println(demo);
        Page<Demo> all = demoRepository.findAll(Example.of(demo, ExampleMatcher.matchingAny().withIgnoreNullValues()), pageRequest);
        ResponseEntity<Page<Demo>> ok = ResponseEntity.ok(all);
        System.out.println(ok);
        return ok;
    }

}
