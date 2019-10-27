package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.service.ChargingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/subscriptions")
public class ChargingDataController {

    @Autowired
    private ChargingDataService chargingDataService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ChargingData> getAll() {
        return chargingDataService.getAllSubscriptions();
    }

    @RequestMapping(value = "/save/{service_id}/{customer_id}/{wallet_id}", method = RequestMethod.POST)
    public ChargingData saveSubscription(@RequestBody ChargingData chargingData, @PathVariable Long service_id, @PathVariable Long customer_id, @PathVariable Long wallet_id) {
        return chargingDataService.saveSubscription(chargingData, service_id, customer_id, wallet_id);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable Long id) {
        chargingDataService.deleteSubscription(id);
    }

}
