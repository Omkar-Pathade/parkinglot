package com.practice.parkinglot.strategy.feecalculation;

import com.practice.parkinglot.model.*;

import java.util.Date;

public class RandomFeesGenerationStrategy implements FeeCalculationStrategy {


    int getTime(Date date1, Date date2) {
        return (int) (date1.getTime() - date2.getTime());
    }

    @Override
    public Payment calculateFees(Ticket ticket, Vehicle vehicle) {
        Date now = new Date();
        int time = getTime(ticket.getEntryTime(), now);
        int amount = 1 * time;
        if (vehicle.getVehicleType().equals(VehicleType.SMALL)) {
            amount *= 10;
        } else if (vehicle.getVehicleType().equals(VehicleType.LARGE)) {
            amount *= 50;
        } else {
            amount *= 75;
        }
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
        payment.setAmount(amount);
        return payment;
    }
}
