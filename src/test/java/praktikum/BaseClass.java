package praktikum;

import net.datafaker.Faker;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BaseClass {
    Faker faker = new Faker();
    Burger burger = new Burger();
    protected String bunName = "Burger";
    protected String nameBurger = faker.food().vegetable();
    protected float price = faker.number().numberBetween(10, 100);
    protected Ingredient ingredient1 = new Ingredient(SAUCE, nameBurger, price);
    protected Ingredient ingredient2 = new Ingredient(FILLING, nameBurger, price);

}
