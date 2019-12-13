package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CService;
import com.netcracker.edu.fapi.models.Subs;

import java.util.List;

public interface CServiceService {

    CService findByName(String name);
    List<CService> findAll();
    CService save(CService cService);
    void delete(Long id);
    Subs getSubscribers(Long id);
}
