package food_handler;

import table.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FoodHandler {
    private static final List<Food> foods = new ArrayList<Food>();

    //new food
    public void add(String name, double price, String group) throws Exception {
        if (foods.stream().anyMatch(food -> Objects.equals(food.getName(), name))){
            throw new Exception();
        }
        FoodHandler.foods.add(new Food(name, price, group));
    }

    //delete food
    public void delete(String name) {
        Food food = (Food) FoodHandler.foods.stream().filter(food1 -> food1.getName().equals(name));
        if (food.getName() == name) {
            FoodHandler.foods.remove(food);
        }
    }
}
