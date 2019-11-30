package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.models.RegistrationViewModel;
import com.netcracker.edu.backend.models.SubscriptionModel;
import com.netcracker.edu.backend.models.UserViewModel;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.ChargingDataService;
import com.netcracker.edu.backend.service.CustomerService;
import com.netcracker.edu.backend.service.UserService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private ChargingDataService chargingDataService;

    @Override
    public List<UserViewModel> getAll() {
        List<User> users = (List<User>) userRepository.findAll();
        List<UserViewModel> models = new ArrayList<>();
        for (User user : users) {
            List<Wallet> wallets = walletService.getWalletsByCustomer(user.getCustomer().getId());
            Double walletAmount = 0.0;
            for (Wallet wallet : wallets) {
                walletAmount += wallet.getAmount();
            }
            UserViewModel model = new UserViewModel(user.getId().toString(), user.getLogin(), user.getCustomer().getEmail(), walletAmount.toString(), user.getRole());
            models.add(model);
        }
        return models;
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User saveUser(RegistrationViewModel model) {
        Customer customer = new Customer();
        customer.setEmail(model.getEmail());
        User user = new User("USER", model.getLogin(), model.getPassword());
        user.setCustomer(customer);
        customerService.saveCustomer(customer);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Customer customer = userRepository.findById(id).orElse(null).getCustomer();
        List<Wallet> wallets = walletService.getWalletsByCustomer(customer.getId());
        wallets.forEach(wallet -> {
            List<SubscriptionModel> chargingData = chargingDataService.getAllByWallet(wallet.getId());
            chargingData.forEach(subscription -> chargingDataService.deleteSubscription(subscription.getId()));
        });
        userRepository.deleteById(id);
        customerService.deleteCustomer(customer.getId());
    }

    @Override
    public User saveCustomer(User user, Customer customer) {
        customerService.saveCustomer(customer);
        user.setCustomer(customer);
        user.setRole("USER");
        return userRepository.save(user);
    }
}
