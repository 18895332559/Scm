package com.lw.scm.action;

import com.lw.scm.bean.Page;
import com.lw.scm.bean.Supplier;
import com.lw.scm.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
            supplierService.insert(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/jsp/main.jsp";
    }

    @RequestMapping("/selectPage")
    @ResponseBody//如果返回的是json格式，需要这个注解
    public Object selectPage(Page<Supplier> page, Supplier supplier) {
        System.out.println("supplier------------------------------:" + supplier);
        page.setParamEntity(supplier);//设置查询条件
        Map<String, Object> pageMap = new HashMap<String, Object>();
        //查询
        page = supplierService.selectPage(page);
        pageMap.put("total", page.getTotalRecord());
        pageMap.put("rows", page.getList());

        System.out.println("集合大小：" + page.getList().size());

        return pageMap;
    }


    @RequestMapping("/selectPageUseDyc")
    @ResponseBody // 返回json
    public Object selectPageUseDyc(Page<Supplier> page, Supplier supplier) {
        page.setParamEntity(supplier);
        page = supplierService.selectPageUseDyc(page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotalRecord());
        map.put("rows", page.getList());
        return map;
    }

    @RequestMapping("/deleteList")
    @ResponseBody
    public Object deleteList(String[] pks) {
        Integer i = 0;
        try {
            i = supplierService.deleteList(pks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(Supplier supplier) {
        Integer i = 0;
        try {
            i = supplierService.update(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


}
