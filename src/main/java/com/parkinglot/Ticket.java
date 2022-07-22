package com.parkinglot;

import lombok.Data;

import java.util.Objects;
import java.util.Random;

@Data
public class Ticket {
    private Long id;
    private Car car;
    public Ticket(){
        Random random=new Random();
        this.id= random.nextLong();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(car, ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car);
    }
}
