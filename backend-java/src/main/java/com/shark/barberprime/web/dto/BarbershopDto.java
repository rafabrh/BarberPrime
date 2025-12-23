package com.shark.barberprime.web.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class BarbershopDto {
    UUID id;
    String name;
    String address;
    String description;
    String imageUrl;
    List<BarbershopServiceDto> services;
}
