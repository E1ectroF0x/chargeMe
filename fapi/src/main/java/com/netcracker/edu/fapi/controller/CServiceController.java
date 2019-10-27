package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CService;
import com.netcracker.edu.fapi.service.CServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class CServiceController {

    @Autowired
    private CServiceService cServiceService;

    @GetMapping(value = "/all")
    public List<CService> getAll() {
        return cServiceService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CService saveCService(@RequestBody CService cService) {
        return cServiceService.save(cService);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void deleteCService(@PathVariable Long id) {
        cServiceService.delete(id);
    }

}
