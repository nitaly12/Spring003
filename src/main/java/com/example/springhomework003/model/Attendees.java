package com.example.springhomework003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendees {
    private Integer attendeeId;
    private String attendeesName;
    private String email;
}
