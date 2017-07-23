package com.wa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {

//    @RequestMapping("/re.do")
//    public String testr(){
//        System.out.printf("重定向 输出测试");
//        return "redirect:/index.jsp";
//    }

    @RequestMapping("/")
    public ModelAndView indexDo(){
        return new ModelAndView("index");
    }
}
