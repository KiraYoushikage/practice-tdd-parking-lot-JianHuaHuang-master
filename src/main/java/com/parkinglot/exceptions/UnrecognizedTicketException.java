package com.parkinglot.exceptions;

import static com.parkinglot.constant.CommonConstant.UNRECOGNIZED_PARKING_TICKET;

public class UnrecognizedTicketException extends RuntimeException{

    public UnrecognizedTicketException() {
        super(UNRECOGNIZED_PARKING_TICKET);
    }
}
