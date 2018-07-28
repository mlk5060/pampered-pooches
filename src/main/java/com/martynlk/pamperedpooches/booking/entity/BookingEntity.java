package com.martynlk.pamperedpooches.booking.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.martynlk.pamperedpooches.booking.configuration.BookingConfiguration;

@Entity
public class BookingEntity {

    @NotNull 
    private final Long id;
    
    @NotBlank
    @Size(max = BookingConfiguration.REFERENCE_LENGTH)
    private final String reference;
    
    @NotNull 
    private final LocalDateTime datetime;
    
    private boolean active;
    
    public BookingEntity(
        Long id,
        String reference,
        LocalDateTime datetime,
        boolean active
    ) {
        this.id = id;
        this.reference = reference;
        this.datetime = datetime;
        this.active = active;
    }

    public Long getId() {
        return id;
    }
    
    public String getReference() {
        return reference;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public boolean isActive() {
        return active;
    }
}
