package com.example.foodsanddrinks.services;

public class FoodExceptions extends RuntimeException {

        public FoodExceptions() {
        }

        public FoodExceptions(String message) {
            super(message);
        }

        public FoodExceptions(String message, Throwable cause) {
            super(message, cause);
        }

    }

