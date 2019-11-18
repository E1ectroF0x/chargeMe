package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.*;

import java.util.List;

public interface ChargingDataService {

    List<ChargingData> findAll();
    List<ChargingData> findAllByCustomer(Long customer_id);
    List<SubscriptionModel> findAllByWallet(Long wallet_id);
    ChargingDataViewModel save(ChargingDataViewModel model);
    void deleteSubscription(String subscription_id);

}
