package com.practice.parkinglot.strategy.feecalculation;

import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.model.Payment;
import com.practice.parkinglot.model.Ticket;
import com.practice.parkinglot.model.Vehicle;

public interface FeeCalculationStrategy {
    public Payment calculateFees(Ticket ticket, Vehicle vehicle);
}
