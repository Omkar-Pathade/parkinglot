package com.practice.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {
    private Map<String, Object> objectMap = new HashMap<>();

    public void register(String name, Object object) {
        objectMap.put(name, object);
    }

    public Object get(String name) {
        return objectMap.get(name);
    }
}
