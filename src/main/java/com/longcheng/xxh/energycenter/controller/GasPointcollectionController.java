package com.longcheng.xxh.energycenter.controller;

import com.longcheng.xxh.energycenter.service.GasPointcollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GasPointcollectionController {

    @Autowired
    private GasPointcollectionService gasPointcollectionService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) String path, HttpServletRequest request, HttpServletResponse response,String dataTable) {
        String result = gasPointcollectionService.upload(path, dataTable);
        return result;
    }
}
