package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTests {
    
    @Test
    void should_return_a_ticket_when_parking_given_a_car() {
        //given
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car();
        //when
        Ticket ticket=parkingLot.parking(car);
        //then
        Assertions.assertNotNull(ticket);
//        Assertions.assertEquals();
    }
    
}
