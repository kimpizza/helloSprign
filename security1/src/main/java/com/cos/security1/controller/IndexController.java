package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // View를 리턴한다
public class IndexController {
    //localhost:8082/
    //localhost:8082
    @GetMapping({"","/"})
    public String index(){
        return "index"; // 이렇게 하면 src/main/resources/templates/index.mustache를 찾게된다.
    }
}
