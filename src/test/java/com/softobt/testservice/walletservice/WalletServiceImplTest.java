package com.softobt.testservice.walletservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Make sure all tests pass
 */
public class WalletServiceImplTest {

    private WalletService walletService;

    @Before
    public void init(){
        walletService = new WalletServiceImpl();
    }

    @Test
    public void testCreationWithZeroBalance(){
        Wallet wallet = new Wallet();
        Assert.assertEquals("Wallet balance is NGN0.00",walletService.getBalance(wallet));
    }

    @Test
    public void testCreditWith10Naira(){
        Wallet wallet = new Wallet();
        String response = walletService.creditWallet(wallet,500L);
        Assert.assertEquals("Credit was successful, balance is NGN10.00",response);
    }

    @Test
    public void testSuccessful10NairaDebit(){
        Wallet wallet = new Wallet();
        String response = "";
        Assert.assertEquals("Debit was successful, balance is NGN0.00",response);
    }

    /**
     * 1 - Create test for unsuccessful NGN10 debit due to insufficient balance
     *     Assert should equal 'Wallet Balance is insufficient'
     * 2 - Create a credit test with minus 100 naira, service should return 'Credit amount is invalid'
     *     Assert should equal 'Credit amount is invalid'
     * 3 - Create a debit test with minus 200 naira, service should return 'Debit amount is invalid'
     *     Assert should equal 'Debit amount is invalid'
     * 4 - Create a test method, credit 500 naira, debit 200 naira, credit 15 naira 45 kobo, test for account balance
     *     Assert should equal 'Wallet balance is NGN315.45'
     */
}