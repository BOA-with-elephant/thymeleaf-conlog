package com.boa.conlog.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/member/index")
    public void MemberAdmin(){}


}
