package com.kaishengit.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 * Created by maoyirun on 2017/7/20.
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "/home";
    }
}
