package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.models.ChargingDataViewModel;
import com.netcracker.edu.backend.repository.ChargingDataRepository;
import com.netcracker.edu.backend.service.CServiceService;
import com.netcracker.edu.backend.service.ChargingDataService;
import com.netcracker.edu.backend.service.CustomerService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class ChargingDataServiceImpl implements ChargingDataService {

    @Autowired
    private ChargingDataRepository chargingDataRepository;

    @Autowired
    private CServiceService cServiceService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WalletService walletService;

    @Override
    public List<ChargingData> getAllSubscriptions() {
        return (List<ChargingData>) chargingDataRepository.findAll();
    }

    @Override
    public List<CService> getAllByWallet(Long wallet_id) {
        Wallet wallet = walletService.getById(wallet_id);
        List<ChargingData> subs = chargingDataRepository.findAllByWalletId(wallet);
        List<CService> cservices = new ArrayList<>();
        for (ChargingData data : subs) {
            cservices.add(data.getServiceId());
        }
        return cservices;
    }

    @Override
    public ChargingData saveSubscription(ChargingDataViewModel model) {
        CService cService = cServiceService.getById(model.getCservice_id());
        Customer customer = customerService.getById(model.getCustomer_id());
        Wallet wallet = walletService.getById(model.getWallet_id());
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

    @Override
    @Scheduled(fixedRate = 5000)
    public void chargeWallets() {
        List<ChargingData> subscriptions = (List<ChargingData>) chargingDataRepository.findAll();
        for (ChargingData sub : subscriptions) {
            if (sub.getWalletId().getAmount() <= 0.0) {
                continue;
            }
            walletService.charge(sub.getWalletId().getId(), sub.getServiceId().getCost());
        }
    }
}
