package com.example.springhomework003.service.serviceimpl;

import com.example.springhomework003.exception.NotFoundException;
import com.example.springhomework003.model.Venue;
import com.example.springhomework003.model.dto.request.VenueRequest;
import com.example.springhomework003.model.dto.response.VenueResponse;
import com.example.springhomework003.repository.VenueRepository;
import com.example.springhomework003.service.VenueService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    private  final VenueRepository venueRepository;
    private final ModelMapper modelMapper;

    public VenueServiceImpl(VenueRepository venueRepository, ModelMapper modelMapper) {
        this.venueRepository = venueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VenueResponse> findAllVenue(Integer offset, Integer limit) {
        offset = (offset -1) * limit;
        List<Venue> venues = venueRepository.findAllVenue(offset, limit);
        List<VenueResponse> venueResponses = new ArrayList<VenueResponse>();
        for (Venue venue : venues){
            venueResponses.add(modelMapper.map(venue,VenueResponse.class));
        }
        return venueResponses;
    }

    @Override
    public VenueResponse createVenue(VenueRequest venueRequest) {
        Venue venue = venueRepository.createVenue(venueRequest);
        return modelMapper.map(venue,VenueResponse.class);
    }

    @Override
    public VenueResponse findVenueById(Integer id){
        Venue venue = venueRepository.findVenueById(id);
        if (venue == null){
            throw new NotFoundException("The venue id " + id + " has not been founded.");
        }
        return modelMapper.map(venue,VenueResponse.class);
    }

    @Override
    public VenueResponse updateVenue(Integer id, VenueRequest venueRequest) {
        Venue venue = venueRepository.updateVenue(id,venueRequest);
        if (venue == null){
            throw new NotFoundException("The venue id " + id + " has not been founded.");
        }
        return modelMapper.map(venue,VenueResponse.class);
    }

    @Override
    public VenueResponse deleteVenue(Integer id) {
        Venue venue = venueRepository.deleteVenue(id);
        if (venue == null){
            throw new NotFoundException("The venue id " + id + " has not been founded.");
        }
        return modelMapper.map(venue,VenueResponse.class);
    }
}
