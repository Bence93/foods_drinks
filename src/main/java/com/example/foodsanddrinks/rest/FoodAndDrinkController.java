package com.example.foodsanddrinks.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.example.foodsanddrinks.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.foodsanddrinks.repository.FoodHandlerRepository;

import java.util.List;
import java.util.Random;

@RestController()
@RequestMapping(path = "/foods")
public class FoodAndDrinkController {

    @Autowired
    private FoodHandlerRepository foodHandler;
    Random random = new Random();
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "req ok",
                    content = {
                            @Content(mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = Food.class))
                            )
                        }
            ),
    })
    @Operation(summary = "Get Food")
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Food> getAllFoods() throws Exception {
        foodHandler.add("Pite"+random.doubles().toString(), 100, "desszert");
        return foodHandler.getAllFood();
    }
}
