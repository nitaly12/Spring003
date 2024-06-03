package com.example.springhomework003.service;

import com.example.springhomework003.model.Event;
import com.example.springhomework003.model.dto.request.EventRequest;
import com.example.springhomework003.model.dto.response.EventResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<Event> findAllEvent(Integer offset, Integer limit);

//    EventResponse createEvent(EventRequest eventRequest);

    EventResponse updateEvent(Integer id, EventRequest eventRequest);

    EventResponse findVenueById(Integer id);

    EventResponse deleteEvent(Integer id);

    EventResponse saveEvent(EventRequest eventRequest);
}
