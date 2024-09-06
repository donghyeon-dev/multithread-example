package com.autocat.multithreadexample.service;

import com.autocat.multithreadexample.domain.Coupon;
import com.autocat.multithreadexample.domain.CouponDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AsyncCouponService {

    public Coupon generateCoupon(CouponDTO couponDTO){
        return Coupon.builder()
                .name(UUID.randomUUID().toString())
                .build();
    }
}
