package com.zunigatomas.gestioneventos.application.service;

import com.zunigatomas.gestioneventos.domain.model.Event;
import com.zunigatomas.gestioneventos.domain.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }
    public List<Event> getAllEvents() {
        return this.repository.findAll();
    }
    public Optional<Event> getEventById(Long id) {
        return this.repository.findById(id);
    }
    public Event createEvent(Event event) {
        return this.repository.save(event);
    }
    public Event updateEvent(Long id, Event updatedEvent) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Event not found");
        }
        updatedEvent.setId(id);
        return repository.save(updatedEvent);
    }
    public void deleteEvent(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Event not found");
        }
        repository.deleteById(id);
    }
}