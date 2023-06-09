package com.practice.parkinglot.repository;

import com.practice.parkinglot.model.Gate;
import com.practice.parkinglot.model.GateType;
import com.practice.parkinglot.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {

    Map<Long, Operator> operatorMap = new HashMap<>();
    int operId = 1;

    public Operator getOperator(long id) {
        if (operatorMap.containsKey(id)) {
            return operatorMap.get(id);
        }
        return setOperator(id, new Operator("Operator " + operId++));
    }

    public Operator setOperator(long id, Operator operator) {
        operatorMap.put(id, operator);
        return operator;
    }

    public Gate getGateById(long id) {
        Gate tempGate = new Gate();
        tempGate.setGateType(GateType.ENTRY);
        tempGate.setOperator(getOperator(id));
        tempGate.setId(id);
        return tempGate;
    }
}
