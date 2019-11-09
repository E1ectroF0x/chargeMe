package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CService;
import com.netcracker.edu.fapi.models.ChargingData;
import com.netcracker.edu.fapi.models.ChargingDataViewModel;
import com.netcracker.edu.fapi.models.Customer;

import java.util.List;

public interface ChargingDataService {

    List<ChargingData> findAll();
    List<ChargingData> findAllByCustomer(Long customer_id);
    List<CService> findAllByWallet(Long wallet_id);
    ChargingDataViewModel save(ChargingDataViewModel model);

}
