package com.example.springhomework003.service.serviceimpl;

import com.example.springhomework003.exception.NotFoundException;
import com.example.springhomework003.model.Attendees;
import com.example.springhomework003.model.dto.request.AttendeesRequest;
import com.example.springhomework003.model.dto.response.AttendeesResponse;
import com.example.springhomework003.model.dto.response.VenueResponse;
import com.example.springhomework003.repository.AttendeesRepository;
import com.example.springhomework003.service.AttendeesService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AttendeesServiceImpl implements AttendeesService {
    private final AttendeesRepository attendeesRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Attendees> findAllAttendees(Integer offset, Integer limit) {
        return attendeesRepository.findAllAttendees(offset, limit);
    }

    @Override
    public Attendees createAttendees(AttendeesRequest attendeesRequest) {
        return attendeesRepository.createAttendees(attendeesRequest);
    }

    @Override
    public AttendeesResponse findAttendeesById(Integer id) {
        Attendees attendees = attendeesRepository.findAttendeesById(id);
        if (attendees == null){
            throw new NotFoundException("The venue id " + id + " has not been founded.");
        }
        return modelMapper.map(attendees, AttendeesResponse.class);
    }

    @Override
    public AttendeesResponse updateAttendees(Integer id, AttendeesRequest attendeesRequest) {
        Attendees attendees = attendeesRepository.updateAttendees(id,attendeesRequest);
        if (attendees == null){
            throw new NotFoundException("The venue id " + id + " has not been founded.");
        }
        return modelMapper.map(attendees, AttendeesResponse.class);
    }

    @Override
    public AttendeesResponse deleteAttendees(Integer id) {
        Attendees attendees = attendeesRepository.deleteAttendees(id);
        if (attendees == null){
            throw new NotFoundException("The venue id " + id + " has not been founded.");
        }
        return modelMapper.map(attendees, AttendeesResponse.class);
    }
}
