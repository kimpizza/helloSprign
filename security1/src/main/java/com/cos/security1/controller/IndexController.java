package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // View를 리턴한다
public class IndexController {
    //localhost:8082/
    //localhost:8082
    @GetMapping({"","/"})
    public String index(){

        return "index"; // 이렇게 하면 src/main/resources/templates/index.mustache를 찾게된다.
    }
    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }
    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }
    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }
    //스프링 시큐리티가 로그인을 낚아챈다.
    @GetMapping("/login")
    public @ResponseBody String login(){
        return "login";
    }
    @GetMapping("/join")
    public @ResponseBody String join(){
        return "join";
    }
    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "회원관리 완료";
    }
}
