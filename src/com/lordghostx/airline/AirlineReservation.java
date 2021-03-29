package com.lordghostx.airline;

public class AirlineReservation {
    private final Passenger[] seatingArrangement = new Passenger[10];

    public void assignSeat(Passenger passenger, SeatType seatType) {
        int freeSeatIndex = findFreeSeat(seatType);

        boolean canAssignSeatToPassenger = freeSeatIndex >= 0 && passenger != null;
        if (canAssignSeatToPassenger)
            assignSeatToPassenger(freeSeatIndex+1,seatType, passenger);

//            createPassengerTicket(freeSeatIndex, passenger, seatType);
    }

    private void assignSeatToPassenger(int ticketNumber, SeatType seatType, Passenger passenger) {
//        createPassengerTicket(ticketNumber,passenger, seatType);
        seatingArrangement[ticketNumber-1] = passenger;
        assignTicket(createTicket(ticketNumber, seatType, passenger), passenger);
    }
//
//    private void createPassengerTicket(int freeSeatIndex, Passenger passenger, SeatType seatType) {
//        seatingArrangement[freeSeatIndex] = passenger;
//        (freeSeatIndex + 1, seatType, passenger);
//    }

    private Ticket createTicket(int ticketNumber, SeatType seatType, Passenger passenger) {
        return new Ticket(ticketNumber, seatType,passenger.getFirstName(), passenger.getLastName());
    }
    private void assignTicket(Ticket ticket, Passenger passenger) {
        passenger.setTicket(ticket);
    }




    private int findFreeSeat(SeatType seatType) {
        int seatStart = 0, seatEnd = 10;
        if (seatType == SeatType.FIRST_CLASS) seatEnd = 5;
        if (seatType == SeatType.ECONOMY) seatStart = 5;
        for (int i = seatStart; i < seatEnd; i++) {
            if (seatingArrangement[i] == null) return i;
        }
        return -1;
    }

    public String getSeatArrangement() {
        StringBuilder seatingArrangement = new StringBuilder();
        for (Passenger i:this.seatingArrangement) {
            if (i == null) seatingArrangement.append("0");
            else seatingArrangement.append("1");
        }

        return seatingArrangement.toString();
    }

    public boolean isFreeSeatAvailable(SeatType seatType) {
        int freeSeatIndex = findFreeSeat(seatType);
        return freeSeatIndex >= 0;
    }

    enum SeatType {
        ECONOMY,
        FIRST_CLASS,
        ALL
    }
}
