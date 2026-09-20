package com.course.day27;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {
    private final DiscountService discounts;
    public DiscountController(DiscountService discounts) { this.discounts = discounts; }

    @GetMapping("/api/discount")
    public Map<String, Integer> discount(@RequestParam int cents, @RequestParam boolean vip) {
        return Map.of("total", discounts.apply(cents, vip));
    }
}
