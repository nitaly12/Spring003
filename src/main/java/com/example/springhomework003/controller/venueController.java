package com.example.springhomework003.controller;

import com.example.springhomework003.model.Venue;
import com.example.springhomework003.model.dto.request.VenueRequest;
import com.example.springhomework003.model.dto.response.VenueResponse;
import com.example.springhomework003.model.apiresponse.APIResponse;
import com.example.springhomework003.service.VenueService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")

public class venueController {
    private final VenueService venueService;

    public venueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<VenueResponse>>> findAllVenue(@Positive
            @RequestParam(defaultValue = "1") Integer offset,@Positive @RequestParam (defaultValue = "3") Integer limit){
        APIResponse<List<VenueResponse>> response = APIResponse.<List<VenueResponse>>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.findAllVenue(offset, limit))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<VenueResponse>> findVenueById(@Positive @PathVariable Integer id){
        APIResponse<VenueResponse> response = APIResponse.<VenueResponse>builder()
                .message("The venue has been successfully founded.")
                .payload(venueService.findVenueById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<VenueResponse>> createVenue(@Valid  @RequestBody VenueRequest venueRequest){
        APIResponse<VenueResponse> response = APIResponse.<VenueResponse>builder()
                .message("The venue has been successfully added.")
                .payload(venueService.createVenue(venueRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<VenueResponse>> updateVenue(@Positive @PathVariable Integer id,@Valid @RequestBody VenueRequest venueRequest){
        APIResponse<VenueResponse> response = APIResponse.<VenueResponse>builder()
                .message("The venue has been successfully updated.")
                .payload(venueService.updateVenue(id, venueRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<VenueResponse>> deleteVenue(@PathVariable Integer id){
        VenueResponse venueResponse = venueService.deleteVenue(id);
        APIResponse<VenueResponse> response = APIResponse.<VenueResponse>builder()
                .message("The venue has been successfully deleted.")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
