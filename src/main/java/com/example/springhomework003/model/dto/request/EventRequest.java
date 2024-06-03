package com.example.springhomework003.model.dto.request;

import com.example.springhomework003.model.Attendees;
import com.example.springhomework003.model.Event;
import com.example.springhomework003.model.Venue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest{
    @NotBlank
    @NotNull(message = "must not be blank")
    private String eventName;
    @NotNull
    private LocalDateTime eventDate;
    @NotNull
    @NotBlank(message = "must not be blank")
    private Integer venueId;
    @NotNull
    @NotEmpty
    List<Integer> attendeesId;

}
