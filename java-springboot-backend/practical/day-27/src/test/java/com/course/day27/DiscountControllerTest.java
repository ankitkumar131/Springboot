package com.course.day27;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DiscountController.class)
class DiscountControllerTest {
    @Autowired MockMvc mvc;
    @MockitoBean DiscountService discounts;

    @Test
    void returnsTotal() throws Exception {
        when(discounts.apply(1000, true)).thenReturn(500);
        mvc.perform(get("/api/discount").param("cents", "1000").param("vip", "true"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.total").value(500));
    }
}
