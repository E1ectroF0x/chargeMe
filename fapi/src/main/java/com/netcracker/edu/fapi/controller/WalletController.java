package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Wallet;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping(value = "/all")
    public List<Wallet> getAll() {
        return walletService.getAll();
    }

    @GetMapping(value = "/{id}")
    public List<Wallet> getByCustomer(@PathVariable Long id) {
        return walletService.getWalletsByCustomer(id);
    }

    @PostMapping
    public void saveWallet(@RequestBody Long customer_id) { walletService.save(customer_id); }

    @PostMapping(value = "/{id}")
    public void refillWallet(@PathVariable Long id, @RequestBody String amount) { walletService.refill(id, amount); }

    @DeleteMapping(value = "/{id}")
    public void deleteWallet(@PathVariable Long id) { walletService.delete(id); }

}
