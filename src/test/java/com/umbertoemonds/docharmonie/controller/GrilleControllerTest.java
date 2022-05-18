package com.umbertoemonds.docharmonie.controller;

import com.umbertoemonds.docharmonie.AbstractWebTest;
import com.umbertoemonds.docharmonie.utils.SecurityConstants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = GrilleController.class)
public class GrilleControllerTest extends AbstractWebTest {
    
    @Test
    protected void findAll() throws Exception {
        var result = login();

        result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/grilles")
                        .header(SecurityConstants.TOKEN_HEADER, getJWT(result)));

        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

}