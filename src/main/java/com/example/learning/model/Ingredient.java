package com.example.learning.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Ingredient implements Persistable<String> {
    @Id
    private final String id;

    private final String name;

    private final Type type;

    // not in DB fields
    private static boolean initialized = false;

    public static void initialize() {
        initialized = true;
    }

    @Override
    public boolean isNew() {
        return !initialized;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
    }
}
