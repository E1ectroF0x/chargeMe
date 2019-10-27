package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.repository.CServiceRepository;
import com.netcracker.edu.backend.service.CServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CServiceServiceImpl implements CServiceService {

    @Autowired
    private CServiceRepository cServiceRepository;

    @Override
    public List<CService> getAllCServices() {
        return (List<CService>) cServiceRepository.findAll();
    }

    @Override
    public CService saveCService(CService cService) {
        return cServiceRepository.save(cService);
    }

    @Override
    public void deleteCService(Long id) {
        cServiceRepository.deleteById(id);
    }

    @Override
    public List<CService> getMoreAve() {
        return cServiceRepository.findAllGreaterThanAverage();
    }


}
