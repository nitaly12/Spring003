package com.example.springhomework003.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeesResponse {
    private Integer attendeeId;
    private String attendeesName;
    private String email;

}
