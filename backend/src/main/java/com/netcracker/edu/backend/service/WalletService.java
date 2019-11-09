package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> getWalletsByCustomer(Long customer_id);
    List<Wallet> getAllWallets();
    Wallet saveWallet(Wallet wallet, Long customer_id);
    void deleteWallet(Long id);
}
