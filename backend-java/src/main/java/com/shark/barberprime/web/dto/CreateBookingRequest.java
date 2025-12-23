package com.shark.barberprime.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
public class CreateBookingRequest {
    @NotNull
    UUID barbershopId;
    @NotNull
    UUID serviceId;
    @NotNull
    UUID userId;
    @NotNull
    @Future
    OffsetDateTime date;
}
