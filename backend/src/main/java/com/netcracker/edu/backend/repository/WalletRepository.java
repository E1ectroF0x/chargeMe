package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {

    @Query(value = "SELECT * FROM `wallets` WHERE `customer_id` = customer_id", nativeQuery = true)
    List<Wallet> findAllByCustomer_id(Long customer_id);
}

