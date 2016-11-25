package com.lw.scm.service;

import com.lw.scm.bean.BuyOrder;

/**
 * Created by lw on 2016/11/24.
 */
public interface BuyOrderService extends BaseService<BuyOrder> {

    public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
}
