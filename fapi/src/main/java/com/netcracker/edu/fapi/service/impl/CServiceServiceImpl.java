package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CService;
import com.netcracker.edu.fapi.service.CServiceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CServiceServiceImpl implements CServiceService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public CService findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        CService cService = restTemplate.getForObject(backendServerUrl + "/api/services/name/" + name, CService.class);
        return cService;
    }

    @Override
    public List<CService> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        CService[] cServiceResponse = restTemplate.getForObject(backendServerUrl + "/api/services/all", CService[].class);
        return cServiceResponse == null ? Collections.emptyList() : Arrays.asList(cServiceResponse);
    }

    @Override
    public CService save(CService cService) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "api/services", cService, CService.class).getBody();
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/services/del/" + id);
    }
}
