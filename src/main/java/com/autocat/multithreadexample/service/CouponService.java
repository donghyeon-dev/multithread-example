package com.autocat.multithreadexample.service;

import com.autocat.multithreadexample.domain.Coupon;
import com.autocat.multithreadexample.domain.CouponDTO;
import com.autocat.multithreadexample.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponService {

    private final AsyncCouponService asyncCouponService;
    private final CouponRepository couponRepository;

    public void insertCoupons() {
        CompletableFuture.supplyAsync(this::generateRandomCoupon)
                .exceptionally(throwable -> {
                    log.error("Error occurred while inserting coupon", throwable);
                    return Coupon.builder().build();
                })
                .thenAccept(coupon -> {
                    if(StringUtils.hasText(coupon.getName())){
                        log.info("Coupon name: " + coupon.getName());
                        couponRepository.save(coupon);
                    } else {
                        log.info("Coupon name is empty");
                    }
                }
        );
    }

    private Coupon generateRandomCoupon() {
        log.info("generateRandomCoupon() method is called by:{}",Thread.currentThread().getName());
        return Coupon.builder()
                .name(UUID.randomUUID().toString())
                .build();
    }
}
