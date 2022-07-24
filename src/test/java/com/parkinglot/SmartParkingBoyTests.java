package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author KiraYous
 * @version V1.0
 * @Package com.parkinglot
 * @date 2022/7/23 14:20
 */
public class SmartParkingBoyTests {


    @Test
    void should_park_in_more_capicaity_when_park_given_a_car_and_a_SmartParkingBoy() {

        //given
        ParkingLot parkingLot1=new ParkingLot(3);
        ParkingLot parkingLot2=new ParkingLot(4);
        SmartParkingBoy parkingBoy=new SmartParkingBoy(parkingLot1,parkingLot2);
        //when
        Car car1=new Car();
        Ticket ticket1=parkingBoy.park(car1);
        Car myCar1=parkingLot2.fetch(ticket1);
        //then
        Assertions.assertNotNull(myCar1);
        Assertions.assertEquals(car1,myCar1);
    }


}
