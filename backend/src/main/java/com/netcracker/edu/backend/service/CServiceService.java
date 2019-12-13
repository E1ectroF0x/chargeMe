package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.models.Subs;

import java.util.List;

public interface CServiceService {

    List<CService> getAllCServices();
    CService getById(Long cservice_id);
    CService saveCService(CService cService);
    void deleteCService(Long id);
    List<CService> getMoreAve();
    Subs getSubscribers(Long id);
}
