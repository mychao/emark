package com.emark.emark.controller;

import com.emark.emark.EmarkApplicationBaseTests;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author myc
 * @version 2016/8/3
 */
public class HomeTests extends EmarkApplicationBaseTests{

    @Test
    public void homeTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"));
    }

}
