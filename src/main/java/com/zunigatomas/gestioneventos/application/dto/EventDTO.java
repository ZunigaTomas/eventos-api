package com.zunigatomas.gestioneventos.application.dto;

import lombok.Data;

@Data
public class EventDTO {
    private String name;
    private String location;
    private String date;
    private int availableTickets;
}