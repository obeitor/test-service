package com.softobt.testservice.walletservice;

public class WalletServiceImpl implements WalletService {
    @Override
    public String creditWallet(Wallet wallet, Long minorAmount) {
        if (minorAmount < 0) {
            return "Credit amount is invalid";
        }
        wallet.addToBalance(minorAmount);
        return "Credit was successful, balance is " + wallet.getBalance();
    }

    @Override
    public String debitWallet(Wallet wallet, Long minorAmount) {
        if (minorAmount < 0) {
            return "Debit amount is invalid";
        } else if (wallet.getMinorBalance() < minorAmount) {
            return "Wallet Balance is insufficient";
        }
        wallet.addToBalance(-1 * minorAmount);
        return "Debit was successful, balance is " + wallet.getBalance();
    }

    @Override
    public String getBalance(Wallet wallet) {
        return "Wallet balance is " + wallet.getBalance();
    }

    @Override
    public String calculateBalance(){
        Wallet account1 = new Wallet();
        creditWallet(account1, 50000L);
        debitWallet(account1, 20000L);
        creditWallet(account1, 1545L);
        return getBalance(account1);
    }


}
