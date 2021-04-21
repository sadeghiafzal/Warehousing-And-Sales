package com.example.demo.service;
import com.example.demo.model.Product;
import com.example.demo.model.factor;
import com.example.demo.model.information;
import com.example.demo.repository.ProductRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//example
    public long gettransportPrice(String Typeoftransport) {

        long price = 20;
        return price;

    }

//example
    public long getProductPrice(long ProductCode) {
        long price = 150;
        return price;

    }
    public JSONObject Calculations(List<information> info)
   {


        float darsad = 1;
        float totalPrice = 0;
        int AccountingCode = 0;
        Random rand = new Random();
        AccountingCode = rand.nextInt(1000);
        long now = System.currentTimeMillis();
        Date sqlDate = new Date(now);

        for (int i = 1; i < info.size(); i++) {

            long productPrice = (int) getProductPrice(info.get(i).getProductCode());//call service productPrice
            long transportPrice = gettransportPrice(info.get(i).getTypeoftransport());//call service transportprice
            if (info.get(i).getProductNumber() > 20)
            {
                darsad = 10 / 100;
            }
            totalPrice = totalPrice + (info.get(i).getProductNumber() * productPrice * transportPrice * darsad);
             Product productInfo = new Product( info.get(i).getProductCode(), sqlDate, sqlDate, info.get(i).getProductNumber(), (int) productPrice, darsad, "پرداخت نشده", AccountingCode, info.get(i).getPaymentCode(), info.get(i).getProductNumber() * productPrice * transportPrice * darsad, info.get(i).getTypeoftransport(), transportPrice);
             productRepository.save(productInfo);
            System.out.println(productInfo.getId());
        }
        JSONObject allData = new JSONObject();
        allData.put("totalPrice", totalPrice);
        allData.put("AccountingCode", AccountingCode);
        return allData;
    }

    public List<Product> findAll() {
        List<Product> AccountingList = new ArrayList<Product>();
        AccountingList = (List<Product>) productRepository.findAll();
        return AccountingList;
    }

    public List<Product> findByPaymentCode(int PaymentCode) {

        List<Product> ProductList = productRepository.findByPaymentCode(PaymentCode);
        return ProductList;
    }

    public List<factor> getProductwithAccountingCode(int AccountingCode)
    {
        List<factor> AccountingList = new ArrayList<factor>();
        List<Product> ProductList = productRepository.findByAccountingCode(AccountingCode);
        for (int i = 1; i < ProductList.size(); i++) {
            AccountingList.add(new factor(ProductList.get(i).getAccountingCode(), ProductList.get(i).getStatuse(), ProductList.get(i).getPaymentCode()));
        }
        return AccountingList;

    }
    public  List < factor> searchByAccountingCode(int AccountingCode, int PaymentCode) {
        int check = 0;
        List<factor> factorList = new ArrayList<factor>();

        List<Product> productList = productRepository.findByAccountingCode(AccountingCode);
        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);

        for (int i = 1; i < productList.size(); i++)
        {

            if (productList.get(i).getStatuse() == "پرداخت شده") {
                return getProductwithAccountingCode(AccountingCode);

            } else if (productList.get(i).getStatuse() == "پرداخت نشده" && productList.get(i).getPaymentCode() == PaymentCode) {
                productList.get(i).setStatuse("پرداخت شده");
                productList.get(i).setPaymentCode(PaymentCode);

                productList.get(i).setDateModifiedD(dateNow);
                Product setInfo = new Product(productList.get(i).getProductCode(), productList.get(i).getDateCreated(), productList.get(i).getDateModifiedD(), productList.get(i).getProductNumber(), productList.get(i).getProductPrice(), productList.get(i).getProfit(), productList.get(i).getStatuse(), productList.get(i).getAccountingCode(), productList.get(i).getPaymentCode(), productList.get(i).getTotalprice(), productList.get(i).getTypeoftransport(), productList.get(i).getTransportPrice());

                productRepository.save(setInfo);
                return getProductwithAccountingCode(AccountingCode);

            }else {
                factorList.add(new factor(0, "این کالا با این کدحسابداری  وجود ندارد", 0));
                return factorList;
            }

        }
        return factorList;
    }

}