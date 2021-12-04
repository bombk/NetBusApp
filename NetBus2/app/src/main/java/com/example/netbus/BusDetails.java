package com.example.netbus;

public class BusDetails {


    private String travelName,source,destination,date,departureTime;
    private int busNo,price,totalSeat;

    public BusDetails(String travelName,String source,String destination, int busNo, int totalSeat, int price,String date, String departureTime) {

        this.travelName = travelName;
        this.busNo = busNo;
        this.totalSeat = totalSeat;
        this.source=source;
        this.destination=destination;
        this.price = price;
        this.date=date;
        this.departureTime = departureTime;
    }

    public String getTravelName() {
        return travelName;
    }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getBusNo() {
        return busNo;
    }
    public int getTotalSeat() {
        return totalSeat;
    }
    public int getPrice() { return price; }
    public String getDate() {
        return date;
    }
    public String getDepartureTime() {
        return departureTime;
    }

}
