package com.parkinglot;

import com.parkinglot.exceptions.NoPositionException;
import com.parkinglot.exceptions.UnrecognizedTicketException;

import java.util.*;

/**
 * @author KiraYous
 * @version V1.0
 * @Package com.parkinglot
 * @date 2022/7/24 12:27
 */
public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    {
        parkingLots=new ArrayList<>();
    }
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }
    public SmartParkingBoy(ParkingLot ...parkingLots) {

        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }


    public Ticket park(Car car) {

        Optional<ParkingLot> optional=this.parkingLots.stream().sorted((o1, o2) -> (o2.getTotalCapacity()-o2.getCurrentCapacity())-(o1.getTotalCapacity()-o1.getCurrentCapacity())).findFirst();

        if(optional.isPresent()){
            ParkingLot parkingLot=optional.get();
            if (parkingLot.getTotalCapacity()!= parkingLot.getCurrentCapacity()){
                return parkingLot.parking(car);
            }
        }
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
