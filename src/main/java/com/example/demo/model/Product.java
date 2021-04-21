package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Product {

   // @Column(name = "ID")
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int productCode;
    private Date dateCreated;
    private Date dateModifiedD;
    private int productNumber;
    private float ProductPrice;
    private float profit;
    private String statuse;
    private int accountingCode;
    private int paymentCode;
    private float totalprice;
    private String typeoftransport;
    private float transportPrice;


    public Product( int productCode, Date dateCreated, Date dateModifiedD, int productNumber, float productPrice, float profit, String statuse, int accountingCode, int paymentCode, float totalprice, String typeoftransport, float transportPrice) {
        this.productCode = productCode;
        this.dateCreated = dateCreated;
        this.dateModifiedD = dateModifiedD;
        this.productNumber = productNumber;
        ProductPrice = productPrice;
        this.profit = profit;
        this.statuse = statuse;
        this.accountingCode = accountingCode;
        this.paymentCode = paymentCode;
        this.totalprice = totalprice;
        this.typeoftransport = typeoftransport;
        transportPrice = transportPrice;

    }

}
//@Document(collection = "ProductDB")
