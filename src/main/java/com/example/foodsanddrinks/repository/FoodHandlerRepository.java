package com.example.foodsanddrinks.repository;

import com.example.foodsanddrinks.models.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FoodHandlerRepository {
    private static final List<Food> foods = new ArrayList<Food>();

    //new food
    public void add(String name, double price, String group) throws Exception {
        if (foods.stream().anyMatch(food -> Objects.equals(food.getName(), name))){
            throw new Exception();
        }
        FoodHandlerRepository.foods.add(new Food(name, price, group));
    }

    //delete food
    public void delete(String name) {
        Food food = (Food) FoodHandlerRepository.foods.stream().filter(food1 -> food1.getName().equals(name));
        if (food.getName() == name) {
            FoodHandlerRepository.foods.remove(food);
        }
    }

    //get all food
    public List<Food> getAllFood() {
        return foods;
    }

}