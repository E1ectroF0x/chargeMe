package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> getWalletsByCustomer(Long customer_id);
    List<Wallet> getAllWallets();
    Wallet getById(Long wallet_id);
    void saveWallet(Long customer_id);
    void deleteWalletsByCustomer(Long customer_id);
    void deleteWallet(Long id);
    void charge(Long wallet_id, Double amount);
    void refill(Long wallet_id, String amount);
}
