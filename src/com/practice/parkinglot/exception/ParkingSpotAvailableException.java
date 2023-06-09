package com.practice.parkinglot.exception;

public class ParkingSpotAvailableException extends Exception {
    public ParkingSpotAvailableException(String noParkingSpotAvailable) {
        super(noParkingSpotAvailable);
    }
}
