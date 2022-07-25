package com.parkinglot;

public interface ParkingLotAction {

    Ticket park(Car car);

    Car fetch(Ticket ticket);
}
