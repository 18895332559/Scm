package com.lw.scm.dao;


import com.lw.scm.bean.BuyOrderDetail;

import java.util.List;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail> {

    int insertList(List<BuyOrderDetail> buyOrderDetailList);
}