package com.upgrad.FoodOrderingApp.api.controller;

import com.upgrad.FoodOrderingApp.api.model.CouponDetailsResponse;
import com.upgrad.FoodOrderingApp.service.businness.OrderService;
import com.upgrad.FoodOrderingApp.service.entities.CouponsEntity;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.CouponNotFoundException;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("order/coupon/{coupon_name}")
    public ResponseEntity<CouponDetailsResponse> getCouponByName(@PathVariable final String coupon_name) throws AuthorizationFailedException,CouponNotFoundException {

        //Check for Authorization

        //Crete a service to do the work

        CouponsEntity couponEntity = orderService.checkCoupon(coupon_name);

        if(couponEntity.getCoupon_name()==null){
            throw new CouponNotFoundException("not found","not found");
        }

        CouponDetailsResponse couponDetailsResponse = new CouponDetailsResponse();

        BeanUtils.copyProperties(couponEntity,couponDetailsResponse);

       return new ResponseEntity<>(couponDetailsResponse,HttpStatus.OK);
    }

    @GetMapping("order")
    public String getPastOrdersOfUser(){

        return "past orders";
    }

    @PostMapping("order")
    public String saveOrder(){

        return "order saved";
    }

}
