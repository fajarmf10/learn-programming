package com.fajarmf.systemdesign.parkinglot;

public class Solution {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.park(new Car("123"));
        parkingLot.park(new Car("456"));
        parkingLot.park(new Car("789"));
        parkingLot.park(new Car("101112"));
        parkingLot.park(new Car("131415"));
        parkingLot.park(new Car("161718"));
        parkingLot.park(new Car("192021"));
        parkingLot.park(new Car("222324"));
        parkingLot.park(new Car("252627"));
        parkingLot.park(new Car("282930"));
        parkingLot.park(new Car("313233"));
        parkingLot.park(new Car("343536"));
        parkingLot.park(new Car("373839"));
        parkingLot.park(new Car("404142"));
        parkingLot.park(new Car("434445"));
        parkingLot.park(new Car("464748"));
        parkingLot.park(new Car("495051"));
        parkingLot.park(new Car("525354"));
        parkingLot.park(new Car("555657"));
        parkingLot.park(new Car("585960"));
        parkingLot.park(new Car("616263"));
        parkingLot.park(new Car("646566"));
        parkingLot.park(new Car("676869"));
        parkingLot.park(new Car("707172"));
        parkingLot.park(new Car("737475"));
        parkingLot.park(new Car("767778"));
        parkingLot.park(new Car("798081"));
        parkingLot.park(new Car("828384"));
        parkingLot.park(new Car("858687"));
        parkingLot.park(new Car("888990"));
        parkingLot.park(new Car("919293"));
        parkingLot.park(new Car("949596"));
        parkingLot.park(new Car("979899"));
        parkingLot.park(new Car("1001011"));
        parkingLot.park(new Car("1031041"));
        parkingLot.park(new Car("1061091"));
        parkingLot.park(new Car("1091141"));
        parkingLot.park(new Car("1121191"));
        parkingLot.park(new Car("1151241"));
        parkingLot.park(new Car("1181291"));
        parkingLot.park(new Car("1211341"));
        parkingLot.park(new Car("1241391"));
        parkingLot.park(new Car("1271441"));

        System.out.println("Available: " + parkingLot.getAvailable());
    }
}
