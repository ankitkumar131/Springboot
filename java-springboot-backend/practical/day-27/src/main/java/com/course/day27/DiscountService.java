package com.course.day27;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public int apply(int cents, boolean vip) {
        if (cents < 0) throw new IllegalArgumentException("cents");
        return vip ? cents / 2 : cents;
    }
}
