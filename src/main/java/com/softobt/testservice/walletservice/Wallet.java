package com.softobt.testservice.walletservice;


import lombok.Getter;

@Getter
public class Wallet {
    private String walletId;
    private Long minorBalance = 0L;
    private String currency = "NGN";

    protected void addToBalance(Long minorAmount){
        this.minorBalance += minorAmount;
    }

    protected  String getBalance(){
        return  String.format("%s%,.2f",this.currency,this.minorBalance.doubleValue()/100);
    }
}
