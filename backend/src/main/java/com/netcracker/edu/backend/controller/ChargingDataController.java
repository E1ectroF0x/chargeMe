package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.models.ChargingDataViewModel;
import com.netcracker.edu.backend.models.SubscriptionModel;
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

    @RequestMapping(value = "/wallet/{id}", method = RequestMethod.GET)
    public List<SubscriptionModel> getByWallet(@PathVariable Long id) {
        return chargingDataService.getAllByWallet(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ChargingData saveSubscription(@RequestBody ChargingDataViewModel model) {
        chargingDataService.chargeWallets();
        return chargingDataService.saveSubscription(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable Long id) {
        chargingDataService.deleteSubscription(id);
    }
}
