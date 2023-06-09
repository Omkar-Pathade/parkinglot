package com.practice.parkinglot.repository;

import com.practice.parkinglot.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Long, Ticket> tickets = new HashMap<>();
    private Long seqId = 0L;

    public Ticket save(Ticket ticket) {
        seqId += 1;
        ticket.setId(seqId);
        tickets.put(seqId, ticket);
        return ticket;
    }
}
