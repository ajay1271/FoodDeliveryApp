package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.entities.CouponsEntity;
import com.upgrad.FoodOrderingApp.service.repositories.OrderDao;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;



    public CouponsEntity checkCoupon(String coupon_name){

        return orderDao.getCouponDetails(coupon_name);



    }

}
