package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.CServiceRepository;
import com.netcracker.edu.backend.repository.ChargingDataRepository;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.ChargingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChargingDataServiceImpl implements ChargingDataService {

    @Autowired
    private ChargingDataRepository chargingDataRepository;

    @Autowired
    private CServiceRepository cServiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<ChargingData> getAllSubscriptions() {
        return (List<ChargingData>) chargingDataRepository.findAll();
    }

    @Override
    public ChargingData saveSubscription(ChargingData chargingData, Long service_id, Long customer_id, Long wallet_id) {
        CService cService = cServiceRepository.findById(service_id).orElse(null);
        Customer customer = customerRepository.findById(customer_id).orElse(null);
        Wallet wallet = walletRepository.findById(wallet_id).orElse(null);
        chargingData.setServiceId(cService);
        chargingData.setCustomerId(customer);
        chargingData.setWalletId(wallet);
        return chargingDataRepository.save(chargingData);
    }

    @Override
    public void deleteSubscription(Long id) {
        chargingDataRepository.deleteById(id);
    }
}
