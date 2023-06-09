package com.practice.parkinglot.model;

public class Operator extends BaseModel {
    private String name;

    public Operator() {
    }

    public Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
