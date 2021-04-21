package com.example.demo.controller;

import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    String token = new String();
    @Autowired
    private MockMvc mockMvc;
    @Autowired
   private ProductRepository productRepository;
    static String BASE_URI = "/api";
    @Autowired
    private WebApplicationContext context;
    @BeforeEach
    void setUp()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getinformationListTest() throws Exception
    {
        this.mockMvc.perform(get(BASE_URI + "/informationList/list").header("token", token))
                .andDo(print())
                .andExpect(status().isOk());
    }

}