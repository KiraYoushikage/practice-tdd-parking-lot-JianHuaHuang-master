package com.parkinglot;

import com.parkinglot.constant.CommonConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ParkingLot {
    private int capacity;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }
    public ParkingLot(){
        this.capacity= CommonConstant.DEFAULT_CAPACITY;
    }
    public Ticket parking(Car car){
        if(capacity>0){
            capacity--;
            return new Ticket();
        }
        return null;
    }

    public Car fetch(Ticket ticket){
        return new Car();
    }
}
