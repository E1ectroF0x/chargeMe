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
    public void save(@RequestBody Long customer_id) {
        walletService.saveWallet(customer_id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        walletService.deleteWallet(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void refill(@PathVariable Long id, @RequestBody String amount) {
        walletService.refill(id, amount);
    }

}
