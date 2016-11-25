package com.lw.scm.service.impl;

import com.lw.scm.bean.AccountRecords;
import com.lw.scm.bean.BuyOrder;
import com.lw.scm.bean.BuyOrderDetail;
import com.lw.scm.dao.BuyOrderMapper;
import com.lw.scm.service.BaseService;
import com.lw.scm.service.BuyOrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by lw on 2016/11/24.
 */
@Service(value = "buyOrderService")
public class BuyOrderServiceImpl extends BaseServiceImpl<BuyOrder> implements BuyOrderService {

    @Override
    public int insertBuyOrder(BuyOrder buyOrder) throws Exception {
        int i = 0;
        //使用UUID生成采购单号,bo表示采购业务
        String boId = "bo" + UUID.randomUUID().toString().replace("-", "");
        buyOrder.setBoId(boId);
        //设置采购明细主键及与采购单的外键值
        //保存订单
        i = buyOrderMapper.insert(buyOrder);
        //设置采购主键和采购单的外键
        for (BuyOrderDetail bod : buyOrder.getBuyOrderDetailList()) {
            //设置订单详情ID
            bod.setBodId(UUID.randomUUID().toString().replace("-", ""));
            //设置订单ID
            bod.setBoId(boId);
        }
        //插入订单详情表
        buyOrderDetailMapper.insertList(buyOrder.getBuyOrderDetailList());
        AccountRecords accountRecords = new AccountRecords();
        // 生成并设置怅务记录的主键
        accountRecords.setArId(String.valueOf("ar" + UUID.randomUUID().toString().replace("-", "")));
        accountRecords.setArAttn(buyOrder.getBoAttn());
        accountRecords.setArArrears(buyOrder.getBoArrears());
        //bo表示商品采购，可以在参数表中加入相关内容
        accountRecords.setArBusType("bo");
        accountRecords.setArDate(buyOrder.getBoDate());
        //优惠金额：用应付金额减去实付金额再减去欠款
        accountRecords.setArDiscount(buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
        accountRecords.setArOperator(buyOrder.getBoOperator());
        //采购单号
        accountRecords.setArOrderId(buyOrder.getBoId());
        accountRecords.setArPaid(buyOrder.getBoPaid());
        accountRecords.setArPayable(buyOrder.getBoPayable());
        accountRecords.setArRemark(buyOrder.getBoRemark());
        accountRecords.setSupId(buyOrder.getSupId());

        accountRecordsMapper.insert(accountRecords);
        return i;
    }
}
