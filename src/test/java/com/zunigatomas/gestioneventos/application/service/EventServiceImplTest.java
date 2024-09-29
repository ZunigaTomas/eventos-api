package com.zunigatomas.gestioneventos.application.service;

import com.zunigatomas.gestioneventos.domain.model.Event;
import com.zunigatomas.gestioneventos.domain.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EventServiceImplTest {
    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventServiceImpl eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEvents() {
        eventService.getAllEvents();
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetEventById() {
        Long id = 1L;
        Event event = new Event();
        when(repository.findById(id)).thenReturn(Optional.of(event));

        Optional<Event> foundEvent = eventService.getEventById(id);

        assertTrue(foundEvent.isPresent());
        assertEquals(event, foundEvent.get());
    }

    @Test
    void testCreateEvent() {
        Event event = new Event();
        when(repository.save(event)).thenReturn(event);

        Event createdEvent = eventService.createEvent(event);

        assertNotNull(createdEvent);
        assertEquals(event, createdEvent);
    }

    @Test
    void testUpdateEvent() {
        Long id = 1L;
        Event event = new Event();
        event.setId(id);
        when(repository.existsById(id)).thenReturn(true);
        when(repository.save(event)).thenReturn(event);

        Event updatedEvent = eventService.updateEvent(id, event);

        assertNotNull(updatedEvent);
        assertEquals(event, updatedEvent);
    }

    @Test
    void testDeleteEvent() {
        Long id = 1L;

        eventService.deleteEvent(id);

        verify(repository, times(1)).deleteById(id);
    }
}
