package com.example.demo.controller;
import com.example.demo.model.Product;
import com.example.demo.model.factor;
import com.example.demo.model.information;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static com.example.demo.controller.AsJsonString.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




import org.junit.runner.RunWith;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)

class AccountingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private WebApplicationContext context;
    ObjectMapper om=new ObjectMapper();

    Product product;
    String token = new String();
  static   long now = System.currentTimeMillis();
   static java.sql.Date dateNow = new java.sql.Date(now);
    static String BASE_URI = "/api";

    void setUp()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();


    }


    @Test
    public void saveInfoTest() throws Exception{
         int productCode=12;
         Date dateCreated=dateNow;
         Date dateModifiedD=dateNow;
         int productNumber=12;
         float ProductPrice=120;
         float profit=10/100;
         String  statuse="پرداخت شده";
         int accountingCode=125;
         int paymentCode=123;
         float totalprice=187;
         String typeoftransport="سواری";
         float transportPrice=65;
         Product testPoduct = new Product(productCode, dateCreated, dateModifiedD,productNumber,ProductPrice,profit,statuse,accountingCode,paymentCode,totalprice,typeoftransport,transportPrice);
        productRepository.save(testPoduct);
    }
    @Test
    public void GenerateAccountingCode() throws Exception{
        Map<String, Object> payload = new HashMap<>();
        List<information> productList= new ArrayList<information>();
        productList.add(new information(12,15,"سواری" ,50));

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URI + "/AccountingCode/productList")
                .content(asJsonString(payload))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getInformationwithAccountingCodeTest() throws Exception{
        this.mockMvc.perform(get(BASE_URI + "/InformationwithAccountingCode/12/14").header("token", token))
                .andDo(print())
                .andExpect(status().isOk());
    }



    @Test
    public void getInformationWithPaymentCodeTest() throws Exception
    {
        this.mockMvc.perform(get(BASE_URI + "/InformationWithPaymentCode/12").header("token", token))
                .andDo(print())
                .andExpect(status().isOk());
    }






}