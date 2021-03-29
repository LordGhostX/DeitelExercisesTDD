package com.lordghostx.airline;

public class Ticket {
    private int ticketNumber;
    private String ticketType;
    private String firstName;
    private String lastName;


    public Ticket(int ticketNumber, AirlineReservation.SeatType seatType, String firstName, String lastName) {
        this.ticketNumber = ticketNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        String seatTypeString;
        if (seatType == AirlineReservation.SeatType.FIRST_CLASS) seatTypeString = "First Class";
        else seatTypeString = "Economy";

        this.ticketType = seatTypeString;
    }

    public int getSeatNumber() {
        return ticketNumber;
    }

    @Override
    public String toString() {

        StringBuilder ticketInfo = new StringBuilder();
        ticketInfo.append("Ticket Type: ").append(ticketType);
        ticketInfo.append("\nSeat Number: ").append(getSeatNumber());
        ticketInfo.append("\nFirst Name: ").append(firstName);
        ticketInfo.append("\nLast Name: ").append(lastName);

        return ticketInfo.toString();

    }
}
