package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.entity.Flight;
import com.test.service.FlightService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FinaltestApplicationTests {

    @Autowired
    private FlightService service;


    @Test
    @Order(1)
    void testSaveFlight() {

        Flight flight = new Flight(201 , "Air India" , "Nagpur" , "Mumbai" , 5000);

        Flight savedFlight = service.save(flight);

        assertNotNull(savedFlight);

        assertEquals(201, savedFlight.getCode());
        
    }


    @Test
    @Order(2)
    void testFindByCode() {

        Flight flight = service.findByCode(201);

        assertNotNull(flight);

        assertEquals("Air India", flight.getCarrier());
        
    }


    @Test
    @Order(3)
    void testFindByCarrier() {

        List<Flight> flights = service.findByCarrier("Air India");

        assertNotNull(flights);
        
    }


    @Test
    @Order(4)
    void testFindByRoute() {

        List<Flight> flights = service.findByRoute("Nagpur" , "Mumbai");

        assertNotNull(flights);
        
    }


    @Test
    @Order(5)
    void testFindByPriceRange() {

        List<Flight> flights = service.findByPriceRange(2000 , 7000);

        assertNotNull(flights);
        
    }


    @Test
    @Order(6)
    void testList() {

        List<Flight> flights = service.list();

        assertNotNull(flights);
        
    }


    @Test
    @Order(7)
    void testDelete() {

        service.delete(201);

        assertNotNull(service.list());
        
    }
}