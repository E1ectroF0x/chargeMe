package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ChargingData;

import java.util.List;

public interface ChargingDataService {
    List<ChargingData> getAllSubscriptions();
    ChargingData saveSubscription(ChargingData chargingData, Long service_id, Long customer_id, Long wallet_id);
    void deleteSubscription(Long id);
}
