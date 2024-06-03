package com.example.springhomework003.service.serviceimpl;

import com.example.springhomework003.exception.NotFoundException;
import com.example.springhomework003.model.Event;
import com.example.springhomework003.model.Venue;
import com.example.springhomework003.model.dto.request.EventRequest;
import com.example.springhomework003.model.dto.response.EventResponse;
import com.example.springhomework003.model.dto.response.VenueResponse;
import com.example.springhomework003.repository.EventRepository;
import com.example.springhomework003.service.EventService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Event> findAllEvent(Integer offset, Integer limit) {
        return eventRepository.findAllEvent(offset, limit);
    }

//    @Override
//    public EventResponse createEvent(EventRequest eventRequest) {
//        Event event = eventRepository.createEvent(eventRequest);
//        return modelMapper.map(event, EventResponse.class);
//    }

    @Override
    public EventResponse updateEvent(Integer id, EventRequest eventRequest) {
        Event event = eventRepository.updateEvent(id, eventRequest);
        return modelMapper.map(event, EventResponse.class);
    }

    @Override
    public EventResponse findVenueById(Integer id) {
        Event event = eventRepository.findEventById(id);
        if (event == null){
            throw new NotFoundException("The venue id " + id + "  has not been founded.");
        }
        return modelMapper.map(event, EventResponse.class);
    }

    @Override
    public EventResponse deleteEvent(Integer id) {
        Event event = eventRepository.deleteEvent(id);
        if (event == null){
            throw new NotFoundException("The event id " + id + "  has not been founded.");
        }
        return modelMapper.map(event, EventResponse.class);
    }

    @Override
    public EventResponse saveEvent(EventRequest eventRequest) {
        Event eventId = eventRepository.saveEvent(eventRequest);
        for(Integer attendeeId : eventRequest.getAttendeesId()){
            eventRepository.saveEventIdAndAttendeesId(eventId.getEventId(),attendeeId);
        }
        return modelMapper.map(eventId, EventResponse.class);
    }


}
