package com.parkinglot.exceptions;

import static com.parkinglot.constant.CommonConstant.NO_AVAILABLE_POSITION;

public class NoPositionException extends RuntimeException {
    public NoPositionException() {
        super(NO_AVAILABLE_POSITION);
    }
}
