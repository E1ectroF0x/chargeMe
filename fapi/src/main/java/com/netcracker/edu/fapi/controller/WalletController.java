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
    public Wallet saveWallet(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }

}
