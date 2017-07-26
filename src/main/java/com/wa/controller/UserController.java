package com.wa.controller;


import com.wa.common.Const;
import com.wa.common.ServerResponse;
import com.wa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService iUserService;


    @RequestMapping("login.do")
    @ResponseBody
    public ServerResponse login(HttpSession session,String name ,String password){
        ServerResponse response = iUserService.login(name, password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

}
