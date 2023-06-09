package com.practice.parkinglot.strategy.spotassignment;

import com.practice.parkinglot.model.*;
import com.practice.parkinglot.repository.ParkingLotRepository;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotWithGate(gate);
        List<ParkingSpot> parkingSpots = ParkingSpot.getParkingSpotByParkingLot(parkingLot);

        for (ParkingSpot ps : parkingSpots) {
            if (ps.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)
                    && ps.getSupportedVehicleTypes().contains(vehicleType)) {
                return ps;
            }
        }
        return null;
    }
}
