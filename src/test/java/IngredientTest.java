import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    private float price;
    private String name;
    private IngredientType type;

    @Test
    public void getPriceTest() {
        price = 45.49f;
        Ingredient ingredient = new Ingredient(SAUCE, "black bun", price);
        float priceActual = ingredient.getPrice();
        assertEquals(price, priceActual, 0);
    }

    @Test
    public void getNameTest() {
        name = "black bun";
        Ingredient ingredient = new Ingredient(SAUCE, name, 45.49f);
        String nameActual = ingredient.getName();
        assertEquals(name, nameActual);
    }

    @Test
    public void getIngredientTypeTest() {
        type = SAUCE;
        Ingredient ingredient = new Ingredient(type, "black bun", 45.49f);
        IngredientType typeActual = ingredient.getType();
        assertEquals(type, typeActual);
    }
}