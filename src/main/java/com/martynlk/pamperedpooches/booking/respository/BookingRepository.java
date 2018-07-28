package com.martynlk.pamperedpooches.booking.respository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.martynlk.pamperedpooches.booking.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{
    
    Stream<ReferencesOnly> findAndStream();
    BookingEntity getByReference(String reference);
}
