package com.example.demo.model;

public class information {
    private int productCode;
    private int ProductNumber;
    private String Typeoftransport;
    private int PaymentCode;

    public information(int productCode, int productNumber, String typeoftransport, int paymentCode) {
        this.productCode = productCode;
        ProductNumber = productNumber;
        Typeoftransport = typeoftransport;
        PaymentCode = paymentCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(int productNumber) {
        ProductNumber = productNumber;
    }

    public String getTypeoftransport() {
        return Typeoftransport;
    }

    public void setTypeoftransport(String typeoftransport) {
        Typeoftransport = typeoftransport;
    }

    public int getPaymentCode() {
        return PaymentCode;
    }

    public void setPaymentCode(int paymentCode) {
        PaymentCode = paymentCode;
    }
}
