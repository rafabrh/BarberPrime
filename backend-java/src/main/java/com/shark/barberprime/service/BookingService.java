package com.shark.barberprime.service;

import com.shark.barberprime.domain.Barbershop;
import com.shark.barberprime.domain.BarbershopService;
import com.shark.barberprime.domain.Booking;
import com.shark.barberprime.domain.User;
import com.shark.barberprime.repository.BarbershopRepository;
import com.shark.barberprime.repository.BarbershopServiceRepository;
import com.shark.barberprime.repository.BookingRepository;
import com.shark.barberprime.repository.UserRepository;
import com.shark.barberprime.web.dto.BookingDto;
import com.shark.barberprime.web.dto.CreateBookingRequest;
import com.shark.barberprime.web.exception.NotFoundException;
import com.shark.barberprime.web.exception.SlotUnavailableException;
import com.shark.barberprime.web.mapper.BarbershopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BarbershopRepository barbershopRepository;
    private final BarbershopServiceRepository serviceRepository;
    private final UserRepository userRepository;
    private final BarbershopMapper mapper;

    @Transactional
    public BookingDto createBooking(CreateBookingRequest request) {
        Barbershop barbershop = barbershopRepository.findById(request.getBarbershopId())
                .orElseThrow(() -> new NotFoundException("Barbearia não encontrada"));
        BarbershopService service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new NotFoundException("Serviço não encontrado"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        OffsetDateTime slot = request.getDate();
        bookingRepository.findActiveBookingForSlot(barbershop.getId(), slot)
                .ifPresent(existing -> {
                    throw new SlotUnavailableException("Horário já reservado para esta barbearia");
                });

        Booking booking = new Booking();
        booking.setId(UUID.randomUUID());
        booking.setBarbershop(barbershop);
        booking.setService(service);
        booking.setUser(user);
        booking.setDate(slot);
        booking.setCancelled(false);
        booking.setCreatedAt(OffsetDateTime.now());

        Booking saved = bookingRepository.save(booking);
        return mapper.toBookingDto(saved);
    }

    @Transactional(readOnly = true)
    public List<BookingDto> listBookingsForDay(UUID barbershopId, OffsetDateTime startOfDay, OffsetDateTime endOfDay) {
        Barbershop barbershop = barbershopRepository.findById(barbershopId)
                .orElseThrow(() -> new NotFoundException("Barbearia não encontrada"));
        return bookingRepository.findByBarbershopAndDateBetween(barbershop, startOfDay, endOfDay)
                .stream()
                .map(mapper::toBookingDto)
                .toList();
    }
}
