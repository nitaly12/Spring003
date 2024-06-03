package com.example.springhomework003.service;

import com.example.springhomework003.model.Venue;
import com.example.springhomework003.model.dto.request.VenueRequest;
import com.example.springhomework003.model.dto.response.VenueResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VenueService {

    List<VenueResponse> findAllVenue(Integer offset, Integer limit);

    VenueResponse createVenue(VenueRequest venueRequest);

    VenueResponse findVenueById(Integer id);

    VenueResponse updateVenue(Integer id, VenueRequest venueRequest);

    VenueResponse deleteVenue(Integer id);

}
