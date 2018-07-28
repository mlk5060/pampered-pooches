package com.martynlk.pamperedpooches.booking.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martynlk.pamperedpooches.booking.dto.BookingDto;
import com.martynlk.pamperedpooches.booking.entity.BookingEntity;
import com.martynlk.pamperedpooches.booking.mapper.BookingMapper;
import com.martynlk.pamperedpooches.booking.respository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    
    private final BookingMapper bookingMapper;
    private final BookingRepository bookingRepository;
    
    @Autowired
    public BookingServiceImpl(
        BookingMapper bookingMapper,
        BookingRepository bookingRepository
    ) {
        this.bookingMapper = bookingMapper;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDto createBooking(@NotNull BookingDto bookingDto) {
        BookingEntity bookingToCreate = bookingMapper.dtoToEntity(bookingDto);
        BookingEntity newBooking =  bookingRepository.save(bookingToCreate);
        
        // TODO: Send e-mail to Mum and customer here.
        
        return bookingMapper.entityToDto(newBooking);
    }

    @Override
    public BookingDto updateBooking(BookingDto bookingDto) {
        
        // Check that booking exists. If this method doesn't retrieve
        // an entity, it will throw a EmptyResultDataAccessException.
        BookingEntity bookingEntity = bookingRepository.getByReference(bookingDto.getReference());
        
        // TODO: May have to validate that the client hasn't changed.
        // TODO: Send e-mail to Mum and customer here.
        
        return bookingMapper.entityToDto(bookingEntity);
    }
}
