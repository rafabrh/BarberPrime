package com.shark.barberprime.web.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class BarbershopServiceDto {
    UUID id;
    String name;
    String description;
    String imageUrl;
    Integer priceInCents;
}
