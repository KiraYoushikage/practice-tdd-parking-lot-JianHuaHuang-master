package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTests {

    // AC1 : Given a parking lot,and a car, When park the car,Then return a parking ticket.

    @Test
    void should_return_a_ticket_when_parking_given_a_car_and_a_parkingLot () {
        //given
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car();
        //when
        Ticket ticket=parkingLot.parking(car);
        //then
        Assertions.assertNotNull(ticket);
//        Assertions.assertEquals();
    }
    // AC1 : Given a parking lot,and a ticket, When fetch the car,Then return a parking Car.
    @Test
    void should_return_a_car_when_fetch_given_a_ticket_and_a_parkingLot() {
        //given
        ParkingLot parkingLot=new ParkingLot();
        Ticket ticket=new Ticket();
        //when
        Car car=parkingLot.fetch(ticket);
        //then
        Assertions.assertNotNull(car);
    }

//    AC5 :   Given a  parking lot which has no capacity , and a car, When park the car,Then can not return  a ticket.
    @Test
    void should_return_null_when_parking_given_a_car_and_a_full_parkingLot() {
        //given
        ParkingLot parkingLot=new ParkingLot(1);
        Car car1=new Car();
        parkingLot.parking(car1);
        Car car=new Car();
        //when
        Ticket ticket=parkingLot.parking(car);
        //then
        Assertions.assertNull(ticket);
    }
    // AC3 :  Given a parking lot with a parked car, and a parking ticket, When fetch the car,Then return the parked car.
    @Test
    void should_return_a_car_when_parking_given_a_ticket_and_a_parkingLot_with_parked_car() {
        //given
        ParkingLot parkingLot=new ParkingLot(1);
        Car car=new Car();
        Ticket ticket=parkingLot.parking(car);

        //when
        Car myCar=parkingLot.fetch(ticket);
        //then
        Assertions.assertNotNull(myCar);
        Assertions.assertEquals(car,myCar);
    }
    // AC4: Given a parking lot with two parked cars, and two parking tickets,When fetch the car twice,Then return the right car with each ticket
    @Test
    void should_return_right_twice_car_when_parking_given_twice_ticket_and_a_parkingLot() {
        //given
        ParkingLot parkingLot=new ParkingLot(2);
        Car car1=new Car();
        Ticket ticket1=parkingLot.parking(car1);
        Car car2=new Car();
        Ticket ticket2=parkingLot.parking(car2);
        //when
        Car myCar1=parkingLot.fetch(ticket1);
        Car myCar2=parkingLot.fetch(ticket2);
        //then
        Assertions.assertNotNull(myCar1);
        Assertions.assertNotNull(myCar2);
        Assertions.assertEquals(car1,myCar1);
        Assertions.assertEquals(car2,myCar2);
    }

}
