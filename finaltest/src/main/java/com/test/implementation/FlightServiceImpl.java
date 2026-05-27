package com.test.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Flight;
import com.test.exception.FlightNotFoundException;
import com.test.repository.FlightRepository;
import com.test.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repo;


    @Override
    public Flight save(Flight flight) {

        return repo.save(flight);
    }


    @Override
    public Flight findByCode(int code) {

        return repo.findByCode(code)
                .orElseThrow(() -> new FlightNotFoundException("Flight Not Found"));
    }


    @Override
    public List<Flight> findByCarrier(String carrier) {

        return repo.findByCarrier(carrier);
    }


    @Override
    public List<Flight> findByRoute(String source, String destination) {

        return repo.findByRoute(source, destination);
    }


    @Override
    public List<Flight> findByPriceRange(double min, double max) {

        return repo.findByPriceRange(min, max);
    }


    @Override
    public List<Flight> list() {

        return repo.findAll();
    }


    @Override
    public void delete(int code) {

        Flight flight = findByCode(code);

        repo.delete(flight);
    }
}