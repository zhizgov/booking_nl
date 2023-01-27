package com.example.bookingnl.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String adress;
    @Column(columnDefinition = "varchar(255) default 'Customer'")
    private String role;


}
