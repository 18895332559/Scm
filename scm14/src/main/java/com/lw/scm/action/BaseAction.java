package com.lw.scm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * Created by lw on 2016/11/17.
 */
@Controller
@RequestMapping(value = "/base")
public class BaseAction {
    //base/goURL/supplier/supplierlist.action
    @Resource
    ServletContext application;

    @RequestMapping("/goURL/{folder}/{file}")
    public String goURL(@PathVariable String folder, @PathVariable String file) {
        return "forward:/WEB-INF/" + folder + "/" + file + ".jsp";
    }
}
