package com.example.foodsanddrinks.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.example.foodsanddrinks.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.foodsanddrinks.repository.FoodHandlerRepository;

import javax.annotation.security.RolesAllowed;
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
//        foodHandler.add("Pite"+random.doubles().toString(), 100, "desszert");
        return foodHandler.getAllFood();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "delete ok",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Food.class)))}
            ),
    })
    @Operation(summary = "Delete Food")
    @DeleteMapping(path = "/delete/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFood(
            @Parameter(description = "Food's name", required = true, example = "Pite")
            @PathVariable(name = "name", required = true) String name) {
        foodHandler.delete(name);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "add ok",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Food.class)))}
            ),
    })
    @Operation(summary = "Add Food")
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("user")
    public Food addFood(
            @Parameter(description = "New Food",required = true)
            @RequestBody(required = true) Food newFood
    ) throws Exception {
        foodHandler.add(newFood.getName(), newFood.getPrice(), newFood.getGroup());
        return newFood;
    }
}
