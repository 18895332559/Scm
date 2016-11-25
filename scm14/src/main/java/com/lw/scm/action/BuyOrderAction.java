package com.lw.scm.action;

import com.lw.scm.bean.BuyOrder;
import com.lw.scm.bean.BuyOrderDetail;

import com.lw.scm.service.BuyOrderService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * Created by lw on 2016/11/24.
 */
@Controller
@RequestMapping("/buyOrder")
public class BuyOrderAction extends BaseAction {

    @Resource
    private BuyOrderService buyOrderService;

    /**
     * 自定义类型转换器
     */
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(
                Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public Object insert(BuyOrder buyOrder, String rows) {
        //将json格式数据转java对象
        ObjectMapper mapper = new ObjectMapper();
        int i = 0;
            try {
            BuyOrderDetail[] buyOrderDetails = mapper.readValue(rows, BuyOrderDetail[].class);
            //设置订单列表
            buyOrder.setBuyOrderDetailList(Arrays.asList(buyOrderDetails));
            //插入
            i = buyOrderService.insertBuyOrder(buyOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;

    }
}
