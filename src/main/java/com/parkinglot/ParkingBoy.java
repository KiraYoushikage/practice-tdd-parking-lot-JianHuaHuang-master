package com.parkinglot;

import com.parkinglot.exceptions.NoPositionException;
import com.parkinglot.exceptions.UnrecognizedTicketException;

import java.util.*;

public class ParkingBoy implements ParkingLotAction {

    private List<ParkingLot> parkingLots;
    private ParkingLotAction parkingLotAction;

    {
        parkingLots = new ArrayList<>();
        parkingLotAction = this;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public ParkingBoy(ParkingLot... parkingLots) {

        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingBoy(ParkingLotAction parkingLotAction) {
        this.parkingLotAction = parkingLotAction;
    }


    public Ticket park(Car car) {
        if (!Objects.equals(this, this.parkingLotAction)) {
            return this.parkingLotAction.park(car);
        }
        Optional<ParkingLot> optional = this.parkingLots.stream().filter(parkingLot -> parkingLot.getCurrentCapacity() != parkingLot.getTotalCapacity()).findFirst();
        if (optional.isPresent()) {
            ParkingLot parkingLot = optional.get();
            return parkingLot.parking(car);
        }
//        return this.parkingLot.parking(car);
        throw new NoPositionException();
    }

    public Car fetch(Ticket ticket) {

        if (!Objects.equals(this, this.parkingLotAction)) {
            return this.fetch(ticket);
        }
        Car car;
        for (ParkingLot parkingLot : this.parkingLots) {
            try {
                car = parkingLot.fetch(ticket);
                if (Objects.nonNull(car)) return car;
            } catch (Exception ignored) {
            }
        }
        throw new UnrecognizedTicketException();
    }
}
