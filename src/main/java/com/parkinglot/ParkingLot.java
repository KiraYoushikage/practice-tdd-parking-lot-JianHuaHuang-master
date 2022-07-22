package com.parkinglot;

import com.parkinglot.constant.CommonConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

public class ParkingLot {
    private int capacity;
    List<Car> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedCars=new ArrayList<>(capacity);
    }
    public ParkingLot(){
        this.capacity= CommonConstant.DEFAULT_CAPACITY;
        parkedCars=new ArrayList<>(capacity);
    }
    public Ticket parking(Car car){
        if(capacity>0){
            capacity--;
            parkedCars.add(car);
            return new Ticket();
        }
        return null;
    }

    public Car fetch(Ticket ticket){
        Car car=parkedCars.get(parkedCars.size()-1);
        parkedCars.remove(parkedCars.size()-1);
        capacity++;
        return car;
    }
}
