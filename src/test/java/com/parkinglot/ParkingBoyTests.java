package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTests {

    @Test
    void should_return_a_car_when_fetch_given_a_ticket_and_a_parkingBoy() {

        //given
        ParkingLot parkingLot=new ParkingLot(2);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car=new Car();
        Ticket ticket=parkingBoy.park(car);
        //when
        Car myCar=parkingBoy.fetch(ticket);
        //then
        Assertions.assertNotNull(myCar);
        Assertions.assertEquals(car,myCar);
    }


    @Test
    void should_return_twice_car_when_fetch_given_twice_ticket_and_twice_parkingBoy() {

        //given
        ParkingLot parkingLot=new ParkingLot(2);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Car car2=new Car();
        Ticket ticket1=parkingBoy.park(car1);
        Ticket ticket2=parkingBoy.park(car2);
        //when
        Car myCar1=parkingBoy.fetch(ticket1);
        Car myCar2=parkingBoy.fetch(ticket2);
        //then
        Assertions.assertNotNull(myCar1);
        Assertions.assertNotNull(myCar2);
        Assertions.assertEquals(car1,myCar1);
        Assertions.assertEquals(car2,myCar2);
    }
}
