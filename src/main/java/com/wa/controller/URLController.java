package com.wa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/web",method = {RequestMethod.POST,RequestMethod.GET})
public class URLController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
