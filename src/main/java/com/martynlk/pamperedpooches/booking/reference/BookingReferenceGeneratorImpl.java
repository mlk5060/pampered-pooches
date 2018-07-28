package com.martynlk.pamperedpooches.booking.reference;

import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martynlk.pamperedpooches.booking.configuration.BookingConfiguration;
import com.martynlk.pamperedpooches.booking.respository.BookingRepository;
import com.martynlk.pamperedpooches.booking.respository.ReferencesOnly;

@Component
public class BookingReferenceGeneratorImpl implements BookingReferenceGenerator {
    
    private final BookingRepository bookingRepository;
    
    @Autowired
    public BookingReferenceGeneratorImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public String generateReference() {
        String newReference = RandomStringUtils.randomAlphabetic(BookingConfiguration.REFERENCE_LENGTH);
        Set<String> existingReferences = bookingRepository
            .findAndStream()
            .map(ReferencesOnly::getReference)
            .collect(Collectors.toSet())
        ;
        while(existingReferences.contains(newReference)) {
            newReference = RandomStringUtils.randomAlphabetic(BookingConfiguration.REFERENCE_LENGTH);
        }
        
        return newReference;
    }

}
