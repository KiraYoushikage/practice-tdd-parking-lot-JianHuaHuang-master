package com.parkinglot;

import com.parkinglot.exceptions.NoPositionException;
import com.parkinglot.exceptions.UnrecognizedTicketException;

import java.util.*;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    {
        parkingLots=new ArrayList<>();
    }
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }
    public ParkingBoy(ParkingLot ...parkingLots) {

        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }


    public Ticket park(Car car) {
        Optional<ParkingLot> optional= this.parkingLots.stream().filter(parkingLot -> parkingLot.getCurrentCapacity()!= parkingLot.getTotalCapacity()).findFirst();
        if(optional.isPresent()){
            ParkingLot parkingLot=optional.get();
            return parkingLot.parking(car);
        }
//        return this.parkingLot.parking(car);
        throw new NoPositionException();
    }

    public Car fetch(Ticket ticket) {
        Car car;
        for (ParkingLot parkingLot: this.parkingLots) {
            try{
                car=parkingLot.fetch(ticket);
                if (Objects.nonNull(car))return car;
            }catch (Exception ignored){ }
        }
        throw new UnrecognizedTicketException();
    }
}
