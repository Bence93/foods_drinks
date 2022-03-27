package com.example.foodsanddrinks.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Schema(description = "Food's name")
    @NotBlank(message = "error.food.name.notblank")
    @NotNull(message = "error.food.name.notnull")
    @Size(max=100, message = "error.food.name.long")
    private String name;

    @Schema(description = "Food's price")
    @Min(value = 1, message = "error.foods.price.min")
    private double price;
    private String group;

    @Builder
    public Food(String name, double price, String group) {
        this.name = name;
        this.price = price;
        this.group = group;
    }
}
