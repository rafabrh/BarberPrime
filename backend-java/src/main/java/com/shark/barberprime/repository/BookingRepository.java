package com.shark.barberprime.repository;

import com.shark.barberprime.domain.Booking;
import com.shark.barberprime.domain.Barbershop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.LockModeType;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from Booking b where b.barbershop.id = :barbershopId and b.date = :date and b.cancelled = false")
    Optional<Booking> findActiveBookingForSlot(@Param("barbershopId") UUID barbershopId, @Param("date") OffsetDateTime date);

    List<Booking> findByBarbershopAndDateBetween(Barbershop barbershop, OffsetDateTime start, OffsetDateTime end);
}
