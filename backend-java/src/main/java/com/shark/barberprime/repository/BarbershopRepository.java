package com.shark.barberprime.repository;

import com.shark.barberprime.domain.Barbershop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbershopRepository extends JpaRepository<Barbershop, UUID> {
}
