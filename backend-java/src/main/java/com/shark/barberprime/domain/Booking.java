package com.shark.barberprime.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings", uniqueConstraints = {
        @UniqueConstraint(name = "uq_booking_slot", columnNames = {"barbershop_id", "date", "cancelled"})
})
@Getter
@Setter
public class Booking {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private BarbershopService service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private OffsetDateTime date;

    private boolean cancelled;

    @Column(name = "cancelled_at")
    private OffsetDateTime cancelledAt;

    @Column(name = "stripe_charge_id")
    private String stripeChargeId;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
