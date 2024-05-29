package com.example.demohttpendpoint.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotNull(message = "Telephone is required")
    private Integer telephone;

    @NotBlank(message = "Language is required")
    private String language;
}
