package cn.loosing.demo.doman;

import org.springframework.data.domain.Sort;

public class PageRequest extends org.springframework.data.domain.PageRequest{
    public PageRequest() {
        super(0,10,Sort.unsorted());
    }
}
