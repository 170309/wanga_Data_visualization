package com.wa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RedirectController {


    @RequestMapping("/")
    public ModelAndView indexDo(){
        return new ModelAndView("login");
    }


    @RequestMapping("/index.redirect")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }


    @RequestMapping("/redirect")
    public ModelAndView redrict(){
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/index.redirect");
        return model;
    }
}
