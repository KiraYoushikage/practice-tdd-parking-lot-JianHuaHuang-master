package com.parkinglot;

import com.parkinglot.exceptions.UnrecognizedTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ParkingBoyTests {

    @Test
    void should_return_a_ticket_when_park_given_a_car_and_a_parkingBoy() {

        //given
        ParkingLot parkingLot=new ParkingLot(2);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        //when
        Car car=new Car();
        Ticket ticket=parkingBoy.park(car);
        //then
        Assertions.assertNotNull(ticket);
    }


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


    @Test
    void should_throw_error_message_when_fetch_given_a_wrong_ticket_and_a_parkingBoy() {
        //given
        ParkingLot parkingLot=new ParkingLot(2);
        Car car1=new Car();
        parkingLot.parking(car1);
        //when
        Executable executable =() -> parkingLot.fetch(new Ticket());
        //then
        UnrecognizedTicketException ticketException = Assertions.assertThrows(UnrecognizedTicketException.class,executable );
        Assertions.assertEquals("Unrecognized parking ticket.",ticketException.getMessage());

    }

    


}
