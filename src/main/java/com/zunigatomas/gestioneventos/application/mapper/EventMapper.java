package com.zunigatomas.gestioneventos.application.mapper;

import com.zunigatomas.gestioneventos.application.dto.EventDTO;
import com.zunigatomas.gestioneventos.domain.model.Event;

public class EventMapper {
    public static EventDTO mapToDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(event.getName());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setDate(event.getDate());
        eventDTO.setAvailableTickets(event.getAvailableTickets());

        return eventDTO;
    }

    public static Event mapToEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setLocation(eventDTO.getLocation());
        event.setDate(eventDTO.getDate());
        event.setAvailableTickets(eventDTO.getAvailableTickets());

        return event;
    }
}
