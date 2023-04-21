package config;

import com.github.javafaker.Faker;

import java.util.Random;

public class PriceNameData {
    public static float PRICE_BUN = new Random().nextFloat();
    public static float PRICE_INGREDIENT = new Random().nextFloat();
    public static float PRICE_INGREDIENT_FILLING = new Random().nextFloat();
    public static float PRICE_INGREDIENT_SAUCE = new Random().nextFloat();
    public static Faker faker = new Faker();
    public static float PRICE = new Random().nextFloat();
    public static String NAME = faker.resolve("food.ingredients");
    public static String NAME_INGREDIENT = faker.resolve("food.ingredients");
    public static String NAME_INGREDIENT_FILLING = faker.resolve("food.ingredients");
    public static String NAME_INGREDIENT_SAUCE = faker.resolve("food.ingredients");


}
