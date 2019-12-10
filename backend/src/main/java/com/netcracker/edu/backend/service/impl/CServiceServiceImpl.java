package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.repository.CServiceRepository;
import com.netcracker.edu.backend.service.CServiceService;
import com.netcracker.edu.backend.service.ChargingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CServiceServiceImpl implements CServiceService {

    @Autowired
    private CServiceRepository cServiceRepository;

    @Autowired
    private ChargingDataService chargingDataService;

    @Override
    public List<CService> getAllCServices() {
        return (List<CService>) cServiceRepository.findAll();
    }

    @Override
    public CService getById(Long cservice_id) {
        return cServiceRepository.findById(cservice_id).orElse(null);
    }

    @Override
    public CService saveCService(CService cService) {
        return cServiceRepository.save(cService);
    }

    @Override
    public void deleteCService(Long id) {
        List<ChargingData> subscriptions = chargingDataService.getAllSubscriptions();
        subscriptions.forEach(subscription -> {
            if (subscription.getServiceId().getId().equals(id)) {
                chargingDataService.deleteSubscription(subscription.getId());
            }
        });
        cServiceRepository.deleteById(id);
    }

    @Override
    public List<CService> getMoreAve() {
        return cServiceRepository.findAllGreaterThanAverage();
    }


}
