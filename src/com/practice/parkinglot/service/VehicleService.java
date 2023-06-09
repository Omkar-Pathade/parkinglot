package com.practice.parkinglot.service;

import com.practice.parkinglot.model.Vehicle;
import com.practice.parkinglot.model.VehicleType;

import java.util.HashMap;

public class VehicleService {

    private HashMap<String, Vehicle> vehicles = new HashMap<>();

    public Vehicle getVehicleByNumber(String number) {
        if (vehicles.containsKey(number)) {
            return vehicles.get(number);
        }
        return null;
    }

    public Vehicle registerVehicle(String number, VehicleType vehicleType) {
        Vehicle tempVehicle = new Vehicle();
        tempVehicle.setVehicleType(vehicleType);
        tempVehicle.setNumber(number);
        vehicles.put(number, tempVehicle);
        return tempVehicle;
    }
}
