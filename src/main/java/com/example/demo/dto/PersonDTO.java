package com.example.demo.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

public class PersonDTO {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @NotNull
    private String firstName;
    @Getter
    @Setter
    @NotNull
    private String lastName;
}
