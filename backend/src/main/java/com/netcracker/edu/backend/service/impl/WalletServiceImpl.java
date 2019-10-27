package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Wallet> getAllWallets() {
        return (List<Wallet>) walletRepository.findAll();
    }

    @Override
    public Wallet saveWallet(Wallet wallet, Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).orElse(null);
        wallet.setCustomer_id(customer);
        return walletRepository.save(wallet);
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }

}
