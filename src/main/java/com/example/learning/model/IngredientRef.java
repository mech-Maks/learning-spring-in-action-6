package com.example.learning.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class IngredientRef {
    private final String ingredient;

    public static List<IngredientRef> of(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(ingredient -> new IngredientRef(ingredient.getName())).collect(Collectors.toList());
    }
}
