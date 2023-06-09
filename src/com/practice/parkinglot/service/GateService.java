package com.practice.parkinglot.service;

import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.model.GateType;
import com.practice.parkinglot.model.Operator;

public class GateService {

    public Gate getGateById(long id){
        Gate tempGate = new Gate();
        tempGate.setGateType(GateType.ENTRY);
        tempGate.setOperator(new Operator());
        return tempGate;
    }
}
