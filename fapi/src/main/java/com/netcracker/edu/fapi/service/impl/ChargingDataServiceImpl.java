package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ChargingData;
import com.netcracker.edu.fapi.models.Customer;
import com.netcracker.edu.fapi.service.ChargingDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ChargingDataServiceImpl implements ChargingDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<ChargingData> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ChargingData[] chargingDataResponse = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/all", ChargingData[].class);
        return chargingDataResponse == null ? Collections.emptyList() : Arrays.asList(chargingDataResponse);
    }

    @Override
    public List<ChargingData> findAllByCustomer(Long customer_id) {
        RestTemplate restTemplate = new RestTemplate();
        ChargingData[] chargingDataResponse = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/customer/" + customer_id, ChargingData[].class);
        return chargingDataResponse == null ? Collections.emptyList() : Arrays.asList(chargingDataResponse);
    }

    @Override
    public ChargingData save(ChargingData chargingData) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscriptions", chargingData, ChargingData.class).getBody();
    }
}