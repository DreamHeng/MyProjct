package ywl.check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by maoyirun on 2017/8/7.
 */
@Controller
public class CheckController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/check")
    public String check(){
        return "check/check";
    }



}
