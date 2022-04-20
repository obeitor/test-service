package com.softobt.testservice.walletservice;

/**
 * Kindly take note of the following
 * - Minor amount means kobo.
 * - Credit and debit amount are done in minor amount
 * - Credit of 500 implies NGN5
 */
public interface WalletService {
     String creditWallet(Wallet wallet, Long minorAmount);
     String debitWallet(Wallet wallet,Long minorAmount);
     String getBalance(Wallet wallet);

}
