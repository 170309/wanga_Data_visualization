package com.wa.controller;


import com.wa.common.Const;
import com.wa.common.ResponseCode;
import com.wa.common.ServerResponse;
import com.wa.pojo.User;
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

    @RequestMapping("logout.do")
    @ResponseBody
    public ServerResponse login(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess("登出成功");
    }

    @RequestMapping("register.do")
    @ResponseBody
    public ServerResponse register(HttpSession session, User user){
        return iUserService.register(user);
    }

//    @RequestMapping("setpwd.do")
//    @ResponseBody
//    public ServerResponse setPwd( String newPassword){
//        return iUserService.updatePassword(newPassword);
//    }

}
