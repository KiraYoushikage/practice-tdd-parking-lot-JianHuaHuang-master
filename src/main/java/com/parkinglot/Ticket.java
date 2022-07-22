package com.parkinglot;

import lombok.Data;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Data
public class Ticket {
    private final Long id;
    private Car car;
    private boolean status;
    public Ticket(){
        Random random=new Random();
        this.id= random.nextLong();
        status=true;
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

    @Test
    public void test(){
        Map<Integer,Integer> map=new HashMap<>(10);
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        System.out.println(map.size());
        map.remove(1);
        System.out.println(map.size());
    }
}
