package com.lw.scm.action;

import com.lw.scm.bean.Goods;
import com.lw.scm.bean.Page;
import com.lw.scm.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lw on 2016/11/20.
 */
@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction {
    @Resource
    private GoodsService goodsService;

    //通过关键字分页查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
    public Object selectPageUseDyc(Page<Goods> page, Goods goods) {

        page.setParamEntity(goods);
        System.out.println("----page:" + page);
        Page p = goodsService.selectPageUseDyc(page);
        //supplier.setSupName("supName1");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", p.getTotalRecord());
        map.put("rows", p.getList());
        return map;
    }
}
