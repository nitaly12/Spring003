package com.example.springhomework003.model.dto.response;

import com.example.springhomework003.model.Attendees;
import com.example.springhomework003.model.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Integer eventId;
    private String eventName;
    private LocalDateTime eventDate;
    private Venue venue;
    List<Attendees> attendees;
}
