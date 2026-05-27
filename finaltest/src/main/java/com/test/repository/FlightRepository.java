package com.test.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.test.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("FROM Flight WHERE code = :code")
    Optional<Flight> findByCode(@Param("code") int code);

    
    @Query("FROM Flight WHERE carrier = :carrier")
    List<Flight> findByCarrier(@Param("carrier") String carrier);

    
    @Query("FROM Flight WHERE source = :source AND destination = :destination")
    List<Flight> findByRoute(@Param("source") String source , @Param("destination") String destination);

    
    @Query("FROM Flight WHERE cost BETWEEN :min AND :max")
    List<Flight> findByPriceRange(@Param("min") double min , @Param("max") double max);
    
}