package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.models.SubscriptionModel;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.ChargingDataService;
import com.netcracker.edu.backend.service.CustomerService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChargingDataService chargingDataService;

    @Override
    public List<Wallet> getWalletsByCustomer(Long customer_id) { return walletRepository.findAllByCustomer_id(customer_id); }

    @Override
    public List<Wallet> getAllWallets() {
        return (List<Wallet>) walletRepository.findAll();
    }

    @Override
    public Wallet getById(Long wallet_id) { return walletRepository.findById(wallet_id).orElse(null); }

    @Override
    public void saveWallet(Long customer_id) {
        Customer customer = customerService.getById(customer_id);
        Wallet wallet = new Wallet();
        wallet.setCustomer_id(customer);
        wallet.setAmount(0.0);
        walletRepository.save(wallet);
    }

    @Override
    public void deleteWalletsByCustomer(Long customer_id) {
        List<Wallet> wallets = this.getWalletsByCustomer(customer_id);
        wallets.forEach(wallet -> deleteWallet(wallet.getId()));
    }

    @Override
    public void deleteWallet(Long id) {
        List<SubscriptionModel> subscriptions = chargingDataService.getAllByWallet(id);
        subscriptions.forEach(subscription -> {chargingDataService.deleteSubscription(subscription.getId());});
        walletRepository.deleteById(id);
    }

    @Override
    public void charge(Long wallet_id, Double amount) {
        Wallet wallet = walletRepository.findById(wallet_id).orElse(null);
        wallet.setAmount(wallet.getAmount() - amount);
        walletRepository.save(wallet);
    }

    @Override
    public void refill(Long wallet_id, String amount) {
        Wallet wallet = walletRepository.findById(wallet_id).orElse(null);
        wallet.setAmount(wallet.getAmount() + Double.parseDouble(amount));
        walletRepository.save(wallet);
    }
}
