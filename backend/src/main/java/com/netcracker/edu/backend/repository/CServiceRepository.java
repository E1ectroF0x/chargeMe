package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CServiceRepository extends CrudRepository<CService, Long> {

    @Query(value = "SELECT * FROM `services` HAVING `cost` > AVG(`cost`)", nativeQuery = true)
    List<CService> findAllGreaterThanAverage();

}
