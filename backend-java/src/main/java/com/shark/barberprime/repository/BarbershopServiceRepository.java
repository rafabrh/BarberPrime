package com.shark.barberprime.repository;

import com.shark.barberprime.domain.BarbershopService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbershopServiceRepository extends JpaRepository<BarbershopService, UUID> {
}
