package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.models.ChargingDataViewModel;
import com.netcracker.edu.backend.repository.CServiceRepository;
import com.netcracker.edu.backend.repository.ChargingDataRepository;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.ChargingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public List<CService> getAllByWallet(Long wallet_id) {
        Wallet wallet = walletRepository.findById(wallet_id).orElse(null);
        List<ChargingData> subs = chargingDataRepository.findAllByWalletId(wallet);
        List<CService> cservices = new ArrayList<>();
        for (ChargingData data : subs) {
            cservices.add(data.getServiceId());
        }
        return cservices;
    }

    @Override
    public ChargingData saveSubscription(ChargingDataViewModel model) {
        CService cService = cServiceRepository.findById(model.getCservice_id()).orElse(null);
        Customer customer = customerRepository.findById(model.getCustomer_id()).orElse(null);
        Wallet wallet = walletRepository.findById(model.getWallet_id()).orElse(null);
        ChargingData chargingData = new ChargingData();
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
