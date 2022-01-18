package com.example.pharmacia.service.impl;

import com.example.pharmacia.model.Booking;
import com.example.pharmacia.repository.BookingRepository;
import com.example.pharmacia.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
  private BookingRepository bookingRepository;
     @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Long getTotalBookings() {
        return bookingRepository.count();
    }
}
