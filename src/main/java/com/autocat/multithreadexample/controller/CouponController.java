package com.autocat.multithreadexample.controller;

import com.autocat.multithreadexample.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;
    @GetMapping
    public void insertMassiveCoupons(){
        for(int i = 0; i < 3000; i++) {
            couponService.insertCoupons();
        };
    };

}
