package com.ny.controler;

import com.ny.bean.SearchRequest;
import com.ny.services.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
public class IndexController {
    @Resource
    IndexService indexService;

    @GetMapping("/index")
    public String getIndex() {
        SearchRequest request = new SearchRequest();
        request.setKeywords(Arrays.asList("A"));
        indexService.getIndex(request);
        return "";
    }
}

