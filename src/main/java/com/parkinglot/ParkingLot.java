package com.parkinglot;

import com.parkinglot.constant.CommonConstant;
import com.parkinglot.exceptions.NoPositionException;
import com.parkinglot.exceptions.UnrecognizedTicketException;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class ParkingLot {
    private final int totalCapacity;
    private int currentCapacity;
    private final Map<Ticket,Car> parkedCars;

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
        throw  new NoPositionException();
    }

    public Car fetch(Ticket ticket){
        if (ticket.isStatus()){
            Car car=parkedCars.get(ticket);
            if (Objects.isNull(car)) throw new UnrecognizedTicketException();
            parkedCars.remove(ticket);
            currentCapacity--;
            ticket.setStatus(false);
            return car;
        }

        throw new UnrecognizedTicketException();
    }
}
