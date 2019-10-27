package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ChargingData;
import com.netcracker.edu.fapi.models.Customer;

import java.util.List;

public interface ChargingDataService {

    List<ChargingData> findAll();
    List<ChargingData> findAllByCustomer(Long customer_id);
    ChargingData save(ChargingData chargingData);

}
