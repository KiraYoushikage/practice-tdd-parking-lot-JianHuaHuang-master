package com.parkinglot;

import com.parkinglot.constant.CommonConstant;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;

@Data

public class ParkingLot {
    private int totalCapacity;
    private int currentCapacity;
    private Map<Ticket,Car> parkedCars;

    public ParkingLot(int capacity) {
        this.totalCapacity= capacity;
        this.currentCapacity=0;
        parkedCars=new HashMap<>(capacity);
    }
    public ParkingLot(){
        this.totalCapacity= CommonConstant.DEFAULT_CAPACITY;
        this.currentCapacity=0;
        parkedCars=new HashMap<>(totalCapacity);
    }
    public Ticket parking(Car car){
        if(currentCapacity<totalCapacity){
            currentCapacity++;
            Ticket ticket=new Ticket();
            parkedCars.put(ticket,car);
            return ticket;
        }
        return null;
    }

    public Car fetch(Ticket ticket){
        Car car=parkedCars.get(ticket);
        parkedCars.put(ticket,null);
        currentCapacity--;
        return car;
    }
}
