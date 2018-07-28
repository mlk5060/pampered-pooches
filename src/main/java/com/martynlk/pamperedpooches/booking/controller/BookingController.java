package com.martynlk.pamperedpooches.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martynlk.pamperedpooches.booking.dto.BookingDto;
import com.martynlk.pamperedpooches.booking.service.BookingService;

@RestController("/booking")
public class BookingController {

    private final BookingService bookingService;
    
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    @PostMapping
    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingService.createBooking(bookingDto);
    }
    
    @PutMapping
    public BookingDto updateBooking(BookingDto bookingDto) {
        return bookingService.updateBooking(bookingDto);
    }
}
