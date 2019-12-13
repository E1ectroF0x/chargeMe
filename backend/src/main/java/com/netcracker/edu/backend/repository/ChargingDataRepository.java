package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CService;
import com.netcracker.edu.backend.entity.ChargingData;
import com.netcracker.edu.backend.entity.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargingDataRepository extends CrudRepository<ChargingData, Long> {

    List<ChargingData> findAllByWalletId(Wallet wallet);

    @Query(value = "SELECT COUNT(subscriptions.customer_id) FROM subscriptions WHERE service_id = :id", nativeQuery = true)
    Long getSubsById(Long id);

}
