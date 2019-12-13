package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.models.ChargingDataViewModel;
import com.netcracker.edu.backend.models.SubscriptionModel;
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
import java.util.concurrent.atomic.AtomicBoolean;

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
    public List<SubscriptionModel> getAllByWallet(Long wallet_id) {
        Wallet wallet = walletService.getById(wallet_id);
        List<ChargingData> subs = chargingDataRepository.findAllByWalletId(wallet);
        List<SubscriptionModel> cservices = new ArrayList<>();
        for (ChargingData data : subs) {
            cservices.add(new SubscriptionModel(data.getId(), data.getServiceId(), data.isBlocked()));
        }
        return cservices;
    }

    @Override
    public ChargingData saveSubscription(ChargingDataViewModel model) {
        CService cService = cServiceService.getById(model.getCservice_id());
        Customer customer = customerService.getById(model.getCustomer_id());
        Wallet wallet = walletService.getById(model.getWallet_id());

        List<SubscriptionModel> subscriptions = getAllByWallet(wallet.getId());
        AtomicBoolean isAlreadySubscribed = new AtomicBoolean(false);
        subscriptions.forEach(subscription -> {
            if (subscription.getCservice().getName().equals(cService.getName())) {
                isAlreadySubscribed.set(true);
            }
        });
        if (isAlreadySubscribed.get()) {
            return null;
        }

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
            if (sub.getWalletId().getAmount() - sub.getServiceId().getCost() >= 0.0) {
                if (sub.isBlocked()) {
                    block(sub.getId());
                }
                walletService.charge(sub.getWalletId().getId(), sub.getServiceId().getCost());
                sub.getWalletId().setAmount(sub.getWalletId().getAmount()-sub.getServiceId().getCost());
            }
            else {
                if (!sub.isBlocked()) {
                    block(sub.getId());
                }
            }
        }
    }

    @Override
    public void block(Long id) {
        ChargingData subscription = this.chargingDataRepository.findById(id).orElse(null);
        subscription.setBlocked(!subscription.isBlocked());
        this.chargingDataRepository.save(subscription);
    }
}
