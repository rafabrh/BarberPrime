package com.shark.barberprime.web.mapper;

import com.shark.barberprime.domain.Barbershop;
import com.shark.barberprime.domain.BarbershopService;
import com.shark.barberprime.domain.Booking;
import com.shark.barberprime.web.dto.BarbershopDto;
import com.shark.barberprime.web.dto.BarbershopServiceDto;
import com.shark.barberprime.web.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarbershopMapper {

    @Mapping(target = "services", expression = "java(barbershop.getServices() == null ? java.util.List.of() : barbershop.getServices().stream().map(this::toServiceDto).toList())")
    BarbershopDto toDto(Barbershop barbershop);

    BarbershopServiceDto toServiceDto(BarbershopService service);

    @Mapping(target = "barbershopId", source = "barbershop.id")
    @Mapping(target = "serviceId", source = "service.id")
    @Mapping(target = "userId", source = "user.id")
    BookingDto toBookingDto(Booking booking);
}
