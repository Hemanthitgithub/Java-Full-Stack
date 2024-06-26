package com.example.policyadminbackend.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Policy {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, max = 100)
    private String name;

    // Other fields, getters, and setters
}
