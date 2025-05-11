package com.dizi.dz.entity;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class Dizi {

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

}
