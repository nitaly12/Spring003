package com.example.springhomework003.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeesRequest {
    @NotBlank
    @NotNull(message = "must not be blank")
    String attendeesName;
    @NotNull
    @NotBlank(message = "must not be blank")
    @Email
    String email;
}
