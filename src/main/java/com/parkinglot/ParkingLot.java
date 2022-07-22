package com.parkinglot;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingLot {
    private int capacity;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car){
        return new Ticket();
    }

}
