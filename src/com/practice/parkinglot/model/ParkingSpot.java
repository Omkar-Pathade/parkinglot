package com.practice.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpot extends BaseModel {
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleTypes;
    private int number;

    public static List<ParkingSpot> getParkingSpotByParkingLot(ParkingLot parkingLot) {
        List<ParkingSpot> parkingList = new ArrayList<>(10);
        //int i = 1;
        for(int i=0;i<10;i++){
            ParkingSpot ps = new ParkingSpot();
            ps.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
            ps.setNumber(i++);
            List<VehicleType> supportedVehicle = List.of(new VehicleType[]{VehicleType.LARGE, VehicleType.MEDIUM, VehicleType.SMALL});
            ps.setSupportedVehicleTypes(supportedVehicle);
            parkingList.add(ps);
        }

        return parkingList;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
