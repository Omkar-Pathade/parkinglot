package com.practice.parkinglot.service;

import com.practice.parkinglot.exception.ParkingSpotAvailableException;
import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.model.Ticket;
import com.practice.parkinglot.model.Vehicle;
import com.practice.parkinglot.model.VehicleType;
import com.practice.parkinglot.repository.TicketRepository;
import com.practice.parkinglot.strategy.spotassignment.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;

    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;

    public TicketService() {
    }

    public TicketService(VehicleService vehicleService, GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws ParkingSpotAvailableException {
        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
        if (vehicle == null) {
            vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGateById(gateId);
        Ticket temp = new Ticket();
        temp.setVehicle(vehicle);
        temp.setEntryTime(new Date());
        temp.setGate(gate);
        temp.setOperator(gate.getOperator());
        temp.setParkingSpot(spotAssignmentStrategy.assignParkingSpot(vehicleType, gate));
        if (temp.getParkingSpot() == null) {
            throw new ParkingSpotAvailableException("No ParkingSpot Available");
        }

        Ticket savedTicket = ticketRepository.save(temp);
        return null;
    }
}
