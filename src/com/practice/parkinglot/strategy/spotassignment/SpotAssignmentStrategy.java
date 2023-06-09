package com.practice.parkinglot.strategy.spotassignment;

import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.model.ParkingSpot;
import com.practice.parkinglot.model.VehicleType;

public interface SpotAssignmentStrategy {

    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate);
}
