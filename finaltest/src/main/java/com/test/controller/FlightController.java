package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.test.entity.Flight;
import com.test.service.FlightService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/flights")
@Validated
public class FlightController {

    @Autowired
    private FlightService service;

    // http://localhost:8080/api/v1/flights/add
    @PostMapping("/add")
    public ResponseEntity<Flight> save(@Valid @RequestBody Flight flight) {

        Flight savedFlight = service.save(flight);

        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
        
    }

    //http://localhost:8080/api/v1/flights/101
    @GetMapping("/{code}")
    public ResponseEntity<Flight> findByCode(@PathVariable int code) {

        Flight flight = service.findByCode(code);

        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/flights/carrier/Indigo
    @GetMapping("/carrier/{carrier}")
    public ResponseEntity<List<Flight>> findByCarrier(@PathVariable String carrier) {

        List<Flight> flights = service.findByCarrier(carrier);

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/flights/route?source=Nagpur&destination=Delhi
    @GetMapping("/route")
    public ResponseEntity<List<Flight>> findByRoute(@RequestParam String source , @RequestParam String destination) {

        List<Flight> flights = service.findByRoute(source, destination);

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    // URL:
    // GET http://localhost:8080/api/v1/flights/price?min=2000&max=7000
    @GetMapping("/price")
    public ResponseEntity<List<Flight>> findByPriceRange(@RequestParam double min , @RequestParam double max) {

        List<Flight> flights = service.findByPriceRange(min, max);

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/flights/all
    @GetMapping("/all")
    public ResponseEntity<List<Flight>> findAll() {

        List<Flight> flights = service.list();

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/flights/101
    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable int code) {

        service.delete(code);

        return new ResponseEntity<>("Flight Deleted Successfully", HttpStatus.OK);
    }
}