package com.wa.controller;


import com.github.pagehelper.PageInfo;
import com.wa.common.ServerResponse;
import com.wa.service.IRepostoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class QueryDataController {

    @Autowired
    private IRepostoryService iRepostoryService;


    @RequestMapping("get_data.do")
    @ResponseBody
    public ServerResponse<PageInfo> queryData(@RequestParam(value = "pagenum",defaultValue = "1") int pagenum,
                                              @RequestParam(value = "pagesize",defaultValue = "10") int pagesize){
        return iRepostoryService.queryData(pagenum, pagesize);
    }


}
