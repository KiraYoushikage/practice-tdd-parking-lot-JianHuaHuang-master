package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author KiraYous
 * @version V1.0
 * @Package com.parkinglot
 * @date 2022/7/24 12:40
 */
public class SuperSmartParkingBoyTests{
    @Test
    void should_park_in_more_proportion_of_capicaity_with__when_park_given_a_car_and_a_SuperSmartParkingBoy() {

        //given
        ParkingLot parkingLot1=new ParkingLot(3);
        ParkingLot parkingLot2=new ParkingLot(4);
        SuperSmartParkingBoy parkingBoy=new SuperSmartParkingBoy(parkingLot1,parkingLot2);
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
