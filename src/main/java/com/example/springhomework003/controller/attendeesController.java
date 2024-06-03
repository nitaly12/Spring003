package com.example.springhomework003.controller;

import com.example.springhomework003.model.Attendees;
import com.example.springhomework003.model.apiresponse.APIResponse;
import com.example.springhomework003.model.dto.request.AttendeesRequest;
import com.example.springhomework003.model.dto.response.AttendeesResponse;
import com.example.springhomework003.model.dto.response.VenueResponse;
import com.example.springhomework003.service.AttendeesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class attendeesController {
    private final AttendeesService attendeesService;

    public attendeesController(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Attendees>>> findAllAttendees(
           @Positive @RequestParam(defaultValue = "1") Integer offset,@Positive @RequestParam (defaultValue = "3") Integer limit){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "All attendees have been successfully fetched.",
                        attendeesService.findAllAttendees(offset, limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @PostMapping
    public ResponseEntity<APIResponse<Attendees>> createAttendees(@Valid @RequestBody AttendeesRequest attendeesRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new APIResponse<>(
                        "The attendees have been successfully added.",
                        attendeesService.createAttendees(attendeesRequest),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<AttendeesResponse>> findAttendeesById(@Positive @PathVariable Integer id){
        APIResponse<AttendeesResponse> response = APIResponse.<AttendeesResponse>builder()
                .message("The venue has been successfully founded.")
                .payload(attendeesService.findAttendeesById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<AttendeesResponse>> updateAttendees(@Positive @PathVariable Integer id,@Valid @RequestBody AttendeesRequest attendeesRequest){
        APIResponse<AttendeesResponse> response = APIResponse.<AttendeesResponse>builder()
                .message("The attendees have been successfully updated.")
                .payload(attendeesService.updateAttendees(id, attendeesRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<AttendeesResponse>> deleteAttendees(@PathVariable Integer id){
        AttendeesResponse attendeesResponse = attendeesService.deleteAttendees(id);
        APIResponse<AttendeesResponse> response = APIResponse.<AttendeesResponse>builder()
                .message("The attendees have been successfully deleted.")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
