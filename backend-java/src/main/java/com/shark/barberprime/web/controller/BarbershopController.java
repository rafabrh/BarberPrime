package com.shark.barberprime.web.controller;

import com.shark.barberprime.repository.BarbershopRepository;
import com.shark.barberprime.web.dto.BarbershopDto;
import com.shark.barberprime.web.mapper.BarbershopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/barbershops")
@RequiredArgsConstructor
public class BarbershopController {

    private final BarbershopRepository repository;
    private final BarbershopMapper mapper;

    @GetMapping
    public ResponseEntity<List<BarbershopDto>> listBarbershops() {
        List<BarbershopDto> items = repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(items);
    }
}
