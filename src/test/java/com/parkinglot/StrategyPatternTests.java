package com.parkinglot;

import com.parkinglot.exceptions.UnrecognizedTicketException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import static com.parkinglot.constant.CommonConstant.UNRECOGNIZED_PARKING_TICKET;

public class StrategyPatternTests {

    @Test
    public void should_pass_test_when__given_a_standard_parkingBoy() {
        //given
        ParkingLot parkingLot1=new ParkingLot(1);
        ParkingLot parkingLot2=new ParkingLot(1);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot1,parkingLot2);
        Car car1=new Car();
        //when
        Ticket ticket1= parkingBoy.park(car1);
        Car myCar1=parkingLot1.fetch(ticket1);

        Car car2=new Car();
        Ticket ticket2=parkingBoy.park(car2);

        Executable executable=()->parkingLot2.fetch(ticket2);
        //then

        Assertions.assertNotNull(myCar1);
        Assertions.assertEquals(car1,myCar1);
        UnrecognizedTicketException unrecognizedTicketException= Assertions.assertThrows(UnrecognizedTicketException.class,executable );
        Assertions.assertEquals(UNRECOGNIZED_PARKING_TICKET,unrecognizedTicketException.getMessage());
    }


    @Test
    public void should_pass_test_when__given_a_smart_parkingBoy() {
        //given
        ParkingLot parkingLot1=new ParkingLot(3);
        ParkingLot parkingLot2=new ParkingLot(4);
        ParkingLotAction parkingLotAction=new SmartParkingBoy(parkingLot1,parkingLot2);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLotAction);
        //when
        Car car1=new Car();
        Ticket ticket1=parkingBoy.park(car1);
        Car myCar1=parkingLot2.fetch(ticket1);
        //then
        Assertions.assertNotNull(myCar1);
        Assertions.assertEquals(car1,myCar1);
    }


    @Test
    public void should_pass_test_when__given_a_super_parkingBoy() {
        //given
        ParkingLot parkingLot1=new ParkingLot(3);
        ParkingLot parkingLot2=new ParkingLot(4);
        ParkingLotAction parkingLotAction=new SuperSmartParkingBoy(parkingLot1,parkingLot2);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLotAction);
        //when
        Car car1=new Car();
        Ticket ticket1=parkingLot1.parking(car1);
        Car car2=new Car();
        Ticket ticket2=parkingLot2.parking(car2);
        Car car3=new Car();
        Ticket ticket3= parkingBoy.park(car3);

        Car myCar3=parkingLot2.fetch(ticket3);
        //then
        Assertions.assertNotNull(myCar3);
        Assertions.assertEquals(car3,myCar3);
    }


}
