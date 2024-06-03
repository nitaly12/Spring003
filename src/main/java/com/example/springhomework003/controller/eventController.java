package com.example.springhomework003.controller;

import com.example.springhomework003.model.Event;
import com.example.springhomework003.model.apiresponse.APIResponse;
import com.example.springhomework003.model.dto.request.EventRequest;
import com.example.springhomework003.model.dto.response.EventResponse;
import com.example.springhomework003.service.EventService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class eventController {
    private final EventService eventService;
    public eventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Event>>> findAllEvent(
        @Positive @RequestParam(defaultValue = "1") Integer offset,@Positive @RequestParam (defaultValue = "3") Integer limit){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "All venues have been successfully fetched.",
                        eventService.findAllEvent(offset, limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<EventResponse>> findEventById(@Positive @PathVariable Integer id){
        APIResponse<EventResponse> response = APIResponse.<EventResponse>builder()
                .message("The venue has been successfully founded.")
                .payload(eventService.findVenueById(id))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<EventResponse>> saveEvent( @RequestBody EventRequest eventRequest){
        APIResponse<EventResponse> response = APIResponse.<EventResponse>builder()
                .message("The venue has been successfully added.")
                .payload(eventService.saveEvent(eventRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<EventResponse>> updateEvent(@PathVariable Integer id,@RequestBody EventRequest eventRequest){
        APIResponse<EventResponse> response = APIResponse.<EventResponse>builder()
                .message("The event has been successfully updated.")
                .payload(eventService.updateEvent(id, eventRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<EventResponse>> deleteEvent(@PathVariable Integer id){
        EventResponse eventResponse = eventService.deleteEvent(id);
        APIResponse<EventResponse> response = APIResponse.<EventResponse>builder()
                .message("The venue has been successfully deleted.")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
