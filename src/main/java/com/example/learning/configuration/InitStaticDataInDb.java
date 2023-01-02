package com.example.learning.configuration;

import com.example.learning.entity.Ingredient;
import com.example.learning.repo.IngredientRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.learning.entity.Ingredient.Type.CHEESE;
import static com.example.learning.entity.Ingredient.Type.PROTEIN;
import static com.example.learning.entity.Ingredient.Type.SAUCE;
import static com.example.learning.entity.Ingredient.Type.VEGGIES;
import static com.example.learning.entity.Ingredient.Type.WRAP;

@Configuration
public class InitStaticDataInDb {
    private final IngredientRepository repo;

    public InitStaticDataInDb(IngredientRepository repo) {
        this.repo = repo;
    }

    @Bean
    public ApplicationRunner dataLoader() {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", SAUCE));
            System.out.println("SAVED ALL INGREDIENTS");
        };
    }
}
