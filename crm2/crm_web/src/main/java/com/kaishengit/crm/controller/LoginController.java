package com.kaishengit.crm.controller;

import com.kaishengit.crm.entity.Account;

import com.kaishengit.crm.service.AccountService;
import com.kaishengit.dto.AjaxResult;
import com.kaishengit.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by maoyirun on 2017/7/19.
 */
@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    /**
     * 跳到登陆页面
     * @return
     */
    @GetMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/")
    @ResponseBody
    public AjaxResult login(String mobile, String password, HttpSession httpSession) {
        try {
            //根据电话号码查找
            Account account = accountService.login(mobile, password);
            httpSession.setAttribute("curr_user", account);
            return AjaxResult.success();
        }catch (AuthenticationException ex){
            return AjaxResult.error("帐号或密码错误");
        }
    }






}
