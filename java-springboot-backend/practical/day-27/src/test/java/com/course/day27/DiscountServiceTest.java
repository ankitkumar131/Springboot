package com.course.day27;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {
    private final DiscountService service = new DiscountService();

    @Test
    void vipGetsHalf() {
        assertThat(service.apply(1000, true)).isEqualTo(500);
    }

    @Test
    void rejectsNegative() {
        assertThatThrownBy(() -> service.apply(-1, false)).isInstanceOf(IllegalArgumentException.class);
    }
}
