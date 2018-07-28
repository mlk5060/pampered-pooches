package com.martynlk.pamperedpooches.booking.service;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.martynlk.pamperedpooches.booking.dto.BookingDto;

@Validated
public interface BookingService {
    BookingDto createBooking(@NotNull BookingDto bookingDto);
    BookingDto updateBooking(@NotNull BookingDto bookingDto);
}
