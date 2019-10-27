package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CService;

import java.util.List;

public interface CServiceService {

    List<CService> getAllCServices();
    CService saveCService(CService cService);
    void deleteCService(Long id);
    List<CService> getMoreAve();
}
