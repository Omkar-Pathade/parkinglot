package com.practice.parkinglot.repository;

import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public ParkingLot getParkingLotWithGate(Gate gate) {
        for (ParkingLot parkinglot : parkingLotMap.values()) {
            if (parkinglot.getGates().contains(gate)) {
                return parkinglot;
            }
        }
        return null;
    }
}
