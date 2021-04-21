
package com.example.demo.controller;
import com.example.demo.model.Product;
import com.example.demo.model.factor;
import com.example.demo.model.information;
import com.example.demo.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class AccountingController {

    private ProductServiceImpl servicee;
    @Autowired
    public AccountingController(ProductServiceImpl servicee) {
        this.servicee = servicee;
    }


//example
    public List<information> Products()
    {
        List<information> list= new ArrayList<information>();
        for (int i=0;i<5;i++)
        {
            list.add(new information(i,i,"سواری",i));
        }
        return list;
    }
    @GetMapping("/api/InformationwithAccountingCode")
    public List<factor> getInformationwithAccountingCode(@RequestParam("AccountingCode") int AccountingCode, @RequestParam("PaymentCode") int PaymentCode )
    {
        log.info("start check Pardakht");
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return servicee.searchByAccountingCode(AccountingCode,PaymentCode);
    }

    @RequestMapping ("/api/AccountingCode")
    public JSONObject GenerateAccountingCode(@RequestParam("AccountingCode") List<information> ProductList )
    {
        log.info("Generate Accounting List");
        List<information> productList = ProductList;
        JSONObject allData = servicee.Calculations(productList);
        return allData;
    }
    @RequestMapping("/api/InformationWithPaymentCode")
    public List<Product>  getInformationWithPaymentCode(@RequestParam("PaymentCode") int PaymentCode)
    {
        log.info("Get Information with PaymentCode");
        List<Product> productInfo= new ArrayList<Product>();
        productInfo=servicee.findByPaymentCode(PaymentCode);
        return productInfo;
    }
}
