package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ChargingData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargingDataRepository extends CrudRepository<ChargingData, Long> {

}
