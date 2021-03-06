package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Wallet;

import java.util.List;

public interface WalletService {

    List<Wallet> getWalletsByCustomer(Long customer_id);
    List<Wallet> getAll();
    void save(Long customer_id);
    void refill(Long wallet_id, String amount);
    void delete(Long wallet_id);
}
