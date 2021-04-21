package com.example.demo.model;

import java.util.Date;

public class factor
{

    private int AccountingCode;
    private String Statuse;
    private int PaymentCode;

    public int getPaymentCode() {
        return PaymentCode;
    }


    public String getStatuse() {
        return Statuse;
    }

    public void setStatuse(String statuse) {
        Statuse = statuse;
    }

    public factor( int accountingCode,String Statuse ,int PaymentCode) {

        AccountingCode = accountingCode;
        this.Statuse=Statuse;
      this.PaymentCode=PaymentCode;

    }


    public void setPaymentCode(int paymentCode) {
        PaymentCode = paymentCode;
    }



    public int getAccountingCode() {
        return AccountingCode;
    }

    public void setAccountingCode(int accountingCode) {
        AccountingCode = accountingCode;
    }
}
