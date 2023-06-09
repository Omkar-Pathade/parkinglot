package com.practice.parkinglot.service;

import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.repository.GateRepository;

public class GateService {

    private GateRepository gateRepository;

    public GateService() {
        this.gateRepository = new GateRepository();
    }

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGateById(long id) {
        return gateRepository.getGateById(id);
    }
}
