package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CService;
import com.netcracker.edu.fapi.models.ChargingData;
import com.netcracker.edu.fapi.models.ChargingDataViewModel;
import com.netcracker.edu.fapi.models.SubscriptionModel;
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

    @GetMapping(value = "/wallet/{id}")
    public List<SubscriptionModel> getByWallet(@PathVariable Long id) { return chargingDataService.findAllByWallet(id); }

    @PostMapping()
    public ChargingDataViewModel saveSubscription(@RequestBody ChargingDataViewModel model) {
        return chargingDataService.save(model);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSubscription(@PathVariable String  id) {
        chargingDataService.deleteSubscription(id);
    }

}
