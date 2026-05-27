package com.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@Column(name = "flight_code")
	private int code;

	@NotBlank(message = "Carrier is required")
	@Column(length = 30, nullable = false)
	private String carrier;

	@NotBlank(message = "Source is required")
	@Column(length = 30, nullable = false)
	private String source;

	@NotBlank(message = "Destination is required")
	@Column(length = 30, nullable = false)
	private String destination;

	@Min(value = 1, message = "Cost must be greater than 0")
	@Column(nullable = false)
	private double cost;

    public Flight() {
    	super();
    }

    public Flight(int code, String carrier, String source, String destination, double cost) {
    	super();
        this.code = code;
        this.carrier = carrier;
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
