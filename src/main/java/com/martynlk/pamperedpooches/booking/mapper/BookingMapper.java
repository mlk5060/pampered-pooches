package com.martynlk.pamperedpooches.booking.mapper;

import org.apache.commons.lang.StringUtils;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.martynlk.pamperedpooches.booking.dto.BookingDto;
import com.martynlk.pamperedpooches.booking.entity.BookingEntity;
import com.martynlk.pamperedpooches.booking.reference.BookingReferenceGenerator;
import com.martynlk.pamperedpooches.configuration.MapStructConfiguration;

@Mapper(config = MapStructConfiguration.class)
public abstract class BookingMapper {
    
    @Autowired private BookingReferenceGenerator bookingReferenceGenerator;
    
    @BeforeMapping
    protected void generateReference(BookingDto bookingDto) { 
        if(StringUtils.isBlank(bookingDto.getReference())) {
            String reference = bookingReferenceGenerator.generateReference();
            bookingDto.setReference(reference);
        }
    }
    
    public abstract BookingEntity dtoToEntity(BookingDto bookingDto);
    public abstract BookingDto entityToDto(BookingEntity bookingEntity);
}
