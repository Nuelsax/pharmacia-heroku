package com.example.pharmacia.service;

import com.example.pharmacia.model.Booking;

import java.util.List;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBooking();
    Long getTotalBookings();
}
