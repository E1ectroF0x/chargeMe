package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.ChargingData;
import com.netcracker.edu.fapi.service.ChargingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/subscriptions")
public class ChargingDataController {

    @Autowired
    private ChargingDataService chargingDataService;

    @GetMapping(value = "/all")
    public List<ChargingData> getAll() {
        return chargingDataService.findAll();
    }

    @GetMapping(value = "/{id}")
    public List<ChargingData> getByCustomer(@PathVariable Long id) {
        return chargingDataService.findAllByCustomer(id);
    }

    @PostMapping
    public ChargingData saveSubscription(@RequestBody ChargingData chargingData) {
        return chargingDataService.save(chargingData);
    }

}
