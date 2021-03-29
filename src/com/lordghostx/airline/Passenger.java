package com.lordghostx.airline;

public class Passenger {
    private String firstName;
    private String lastName;
    private Ticket passengerTicket;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passengerTicket = null;
    }

    public void setTicket(Ticket ticket) {
        passengerTicket = ticket;
    }

    public String getTicketInfo() {
        if (passengerTicket == null) return null;
        return passengerTicket.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return  lastName;
    }
}
