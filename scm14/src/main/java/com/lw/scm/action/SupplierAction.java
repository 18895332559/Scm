package com.lw.scm.action;

import com.lw.scm.bean.Supplier;
import com.lw.scm.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lw on 2016/11/16.
 */
@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction {
    @Resource
    private SupplierService supplierService;


    @RequestMapping(value = "/insert")
    public String insert(Supplier supplier) {
        try {
            System.out.println("supplier:" + supplier);
            supplierService.insert(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/jsp/main.jsp";
    }

    @RequestMapping("/doAjax")
    @ResponseBody//如果返回的是json格式，需要这个注解
    public Object doAjax(Supplier supplier) {
        supplier.setSupName("suppName");
        return supplier;
    }
}
