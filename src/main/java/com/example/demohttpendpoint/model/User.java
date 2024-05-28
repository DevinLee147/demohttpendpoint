package com.example.demohttpendpoint.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Username is required")
//    @Column(unique = true)
    private String username;

//    @NotNull(message = "Telephone is required")
//    @Min(value = 10000000, message = "Telephone number must be at least 8 digits")
    private Integer telephone;

//    @NotBlank(message = "Language is required")
    private String language;
}
