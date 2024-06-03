package com.example.springhomework003.service;

import com.example.springhomework003.model.Attendees;
import com.example.springhomework003.model.dto.request.AttendeesRequest;
import com.example.springhomework003.model.dto.response.AttendeesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendeesService {
    List<Attendees> findAllAttendees(Integer offset, Integer limit);

    Attendees createAttendees(AttendeesRequest attendeesRequest);

    AttendeesResponse findAttendeesById(Integer id);

    AttendeesResponse updateAttendees(Integer id, AttendeesRequest attendeesRequest);

    AttendeesResponse deleteAttendees(Integer id);
}
