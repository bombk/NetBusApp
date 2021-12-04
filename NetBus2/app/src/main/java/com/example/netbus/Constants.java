package com.example.netbus;

public class Constants {

    private static final String ROOT_URL = "http://192.168.1.66/NetBus/v1/";

    public static final String URL_REGISTER = ROOT_URL+"registerUser.php";
    public static final String URL_LOGIN = ROOT_URL+"userLogin.php";

    public static final String ShowTicket_URL = "http://192.168.1.66/NetBus/showTicket.php?userName=";
    public static final String AdminShowTicket_URL = "http://192.168.1.66/NetBus/adminShowTicket.php?busNo=";
    public static final String AdminShowBus_URL = "http://192.168.1.66/NetBus/adminShowBus.php";
    public static final String KEY_TICKETNUMBER = "ticketNumber";
    public static final String KEY_TRAVELNAME = "travelName";
    public static final String KEY_BUSNO = "busNo";
    public static final String KEY_PRICE =  "price";
    public static final String KEY_SEATNO =  "seatNo";
    public static final String KEY_SOURCE =  "source";
    public static final String KEY_DESTINATION =  "destination";
    public static final String KEY_DATE =  "date";
    public static final String KEY_DEPARTURETIME =  "departureTime";
    public static final String KEY_TOTALSEAT="totalSeat";
    public static final String JSON_ARRAY = "result";

}
