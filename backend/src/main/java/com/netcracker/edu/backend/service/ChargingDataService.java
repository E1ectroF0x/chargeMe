package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.models.ChargingDataViewModel;
import com.netcracker.edu.backend.models.SubscriptionModel;

import java.util.List;

public interface ChargingDataService {
    List<ChargingData> getAllSubscriptions();
    List<SubscriptionModel> getAllByWallet(Long wallet_id);
    ChargingData saveSubscription(ChargingDataViewModel model);
    void deleteSubscription(Long id);
    void chargeWallets();
    void block(Long id);
}
