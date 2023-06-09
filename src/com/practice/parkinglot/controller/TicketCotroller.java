package com.practice.parkinglot.controller;

import com.practice.parkinglot.dto.GenerateTicketRequest;
import com.practice.parkinglot.dto.GenerateTicketResponse;
import com.practice.parkinglot.dto.ResponseStatus;
import com.practice.parkinglot.exception.ParkingSpotAvailableException;
import com.practice.parkinglot.model.Ticket;
import com.practice.parkinglot.service.TicketService;

public class TicketCotroller {

    private TicketService ticketService;

    public TicketCotroller(TicketService ticketService) {
    }

    public GenerateTicketResponse generateTicket(GenerateTicketRequest generateTicketRequest) {
        try {
            Ticket ticket = ticketService.generateTicket(generateTicketRequest.getVehicleNo(),
                    generateTicketRequest.getVehicleType(),
                    generateTicketRequest.getGateId());
            GenerateTicketResponse response = new GenerateTicketResponse();
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setTicket(ticket);
            return response;
        } catch (ParkingSpotAvailableException e) {
            GenerateTicketResponse response = new GenerateTicketResponse();
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }

    }
}
