package com.autocat.multithreadexample.repository;

import com.autocat.multithreadexample.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository  extends JpaRepository<Coupon, Long> {
}
