package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
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
    public List<SubscriptionModel> findAllByWallet(Long wallet_id) {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionModel[] chargingDataResponse = restTemplate.getForObject(backendServerUrl + "/api/subscriptions/wallet/" + wallet_id, SubscriptionModel[].class);
        return chargingDataResponse == null ? Collections.emptyList() : Arrays.asList(chargingDataResponse);
    }

    @Override
    public ChargingDataViewModel save(ChargingDataViewModel model) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscriptions/", model, ChargingDataViewModel.class).getBody();
    }

    @Override
    public void deleteSubscription(String subscription_id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscriptions/" + subscription_id);
    }


}
