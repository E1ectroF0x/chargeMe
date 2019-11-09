package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Wallet> getAll() {
        return walletService.getAllWallets();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Wallet> getAllByCustomer(@PathVariable Long id) { return walletService.getWalletsByCustomer(id); }

    @RequestMapping(method = RequestMethod.POST)
    public Wallet save(@RequestBody Wallet wallet, @PathVariable Long customer_id) {
        return walletService.saveWallet(wallet, customer_id);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        walletService.deleteWallet(id);
    }

}
