package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Wallet;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Wallet> getWalletsByCustomer(Long customer_id) {
        RestTemplate restTemplate = new RestTemplate();
        Wallet[] wallets = restTemplate.getForObject(backendServerUrl + "/api/wallets/" + customer_id, Wallet[].class);
        return wallets == null ? Collections.emptyList() : Arrays.asList(wallets);
    }

    @Override
    public List<Wallet> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Wallet[] walletsResponse = restTemplate.getForObject(backendServerUrl + "/api/wallets/all", Wallet[].class);
        return walletsResponse == null ? Collections.emptyList() : Arrays.asList(walletsResponse);
    }

    @Override
    public void save(Long customer_id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/wallets", customer_id, Long.class).getBody();
    }

    @Override
    public void refill(Long wallet_id, String amount) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/wallets/" + wallet_id.toString(), amount, String.class);
    }

    @Override
    public void delete(Long wallet_id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/wallets/" + wallet_id.toString());
    }
}
