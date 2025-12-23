package com.shark.barberprime.web.dto;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class BookingDto {
    UUID id;
    UUID barbershopId;
    UUID serviceId;
    UUID userId;
    OffsetDateTime date;
    boolean cancelled;
    OffsetDateTime cancelledAt;
    String stripeChargeId;
}
