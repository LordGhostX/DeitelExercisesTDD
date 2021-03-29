package com.lordghostx.airline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirlineReservationTest {
    AirlineReservation airline;
    Passenger passenger;


    @BeforeEach
    void beforeEach() {
        airline = new AirlineReservation();
        passenger = new Passenger("Solomon", "Ghost");
    }

    @AfterEach
    void afterEach() {
        airline = null;
        passenger = null;
    }

    @Test
    void airlineCanAssignFirstClassSeat() {
        assertEquals("0000000000", airline.getSeatArrangement());

        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        assertEquals("1000000000", airline.getSeatArrangement());

        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        assertEquals("1110000000", airline.getSeatArrangement());
    }

    @Test
    void airlineCanAssignEconomySeat() {
        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        assertEquals("0000010000", airline.getSeatArrangement());

        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        assertEquals("0000011100", airline.getSeatArrangement());
    }

    @Test
    void airlineCannotAssignSeatToNullUser() {
        airline.assignSeat(null, AirlineReservation.SeatType.ECONOMY);
        airline.assignSeat(null, AirlineReservation.SeatType.FIRST_CLASS);
        assertEquals("0000000000", airline.getSeatArrangement());
    }

    @Test
    void airlineCannotAssignPassengerToTakenSeat() {
        for (int i = 0; i < 6; i++) {
            airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        }

        assertEquals("0000011111", airline.getSeatArrangement());
    }

    @Test
    void airlineCanKnowIfSeatTypeIsFree() {
        assertTrue(airline.isFreeSeatAvailable(AirlineReservation.SeatType.ECONOMY));

        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        assertTrue(airline.isFreeSeatAvailable(AirlineReservation.SeatType.ECONOMY));

        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        assertFalse(airline.isFreeSeatAvailable(AirlineReservation.SeatType.ECONOMY));

        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        assertTrue(airline.isFreeSeatAvailable(AirlineReservation.SeatType.FIRST_CLASS));

        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        assertFalse(airline.isFreeSeatAvailable(AirlineReservation.SeatType.FIRST_CLASS));
    }

    @Test
    void airlineCanKnowIfAnySeatTypeIsFree() {
        assertTrue(airline.isFreeSeatAvailable(AirlineReservation.SeatType.ALL));

        for (int i = 0; i < 5; i++) {
            airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        }

        assertTrue(airline.isFreeSeatAvailable(AirlineReservation.SeatType.ALL));

        for (int i = 0; i < 5; i++) {
            airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        }

        assertFalse(airline.isFreeSeatAvailable(AirlineReservation.SeatType.ALL));
    }

    @Test
    void airlineCanCreateTicketForPassenger() {
        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        assertEquals("Ticket Type: First Class\nSeat Number: 1\nFirst Name: Solomon\nLast Name: Ghost", passenger.getTicketInfo());

        airline.assignSeat(passenger, AirlineReservation.SeatType.ECONOMY);
        assertEquals("Ticket Type: Economy\nSeat Number: 6\nFirst Name: Solomon\nLast Name: Ghost", passenger.getTicketInfo());
    }

    @Test
    void airlineCanGetPassengerTicketInfo() {
        airline.assignSeat(passenger, AirlineReservation.SeatType.FIRST_CLASS);
        assertEquals("Ticket Type: First Class\nSeat Number: 1\nFirst Name: Solomon\nLast Name: Ghost", passenger.getTicketInfo());
        System.out.println(passenger.getTicketInfo());
        Passenger secondPassenger = new Passenger("Lord", "GhostX");
        airline.assignSeat(secondPassenger, AirlineReservation.SeatType.FIRST_CLASS);
        System.out.println(passenger.getTicketInfo());

        assertEquals("Ticket Type: First Class\nSeat Number: 2\nFirst Name: Lord\nLast Name: GhostX", secondPassenger.getTicketInfo());
    }

    @Test
    void airlineCannotGetTicketInfoOfNullPassenger() {
        assertNull(passenger.getTicketInfo());
    }

}