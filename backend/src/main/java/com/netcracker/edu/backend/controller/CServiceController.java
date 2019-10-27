package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.service.CServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "api/services")
public class CServiceController {

    @Autowired
    private CServiceService cServiceService;

   @RequestMapping(value = "/all", method = RequestMethod.GET)
   public List<CService> getAll() {
       return cServiceService.getAllCServices();
   }

    @RequestMapping(method = RequestMethod.POST)
    public CService save(@RequestBody CService cService) {
        return cServiceService.saveCService(cService);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        cServiceService.deleteCService(id);
    }

    @RequestMapping(value = "/moreAverage", method = RequestMethod.GET)
    public List<CService> getMoreAve() { return cServiceService.getMoreAve(); }

}
