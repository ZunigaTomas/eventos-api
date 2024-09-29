package com.zunigatomas.gestioneventos.domain.repository;

import com.zunigatomas.gestioneventos.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
