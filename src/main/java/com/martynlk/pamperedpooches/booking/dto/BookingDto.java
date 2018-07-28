package com.martynlk.pamperedpooches.booking.dto;

import java.time.LocalDateTime;

public class BookingDto {

    private String reference;
    private LocalDateTime datetime;
    private boolean active;

    public BookingDto(
        LocalDateTime datetime,
        boolean active
    ) {
        this.datetime = datetime;
        this.active = active;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
