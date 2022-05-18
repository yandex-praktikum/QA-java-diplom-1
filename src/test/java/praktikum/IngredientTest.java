package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private final String sauceName = "Кетчуп";
    private final String fillingName = "Говядина";
    private final float intPrice = 5;
    private final float doublePrice = 22.0f;
    private final IngredientType sauceType = SAUCE;
    private final IngredientType fillingType = FILLING;

    @Test

    public void getPriceWithIntegerValue() {

        Ingredient ingredient = new Ingredient(sauceType, sauceName, intPrice);
        float expectedPrice = 5;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getPriceWithDoubleValue() {

        Ingredient ingredient = new Ingredient(sauceType, sauceName, doublePrice);
        float expectedPrice = 22.0f;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getSauceName() {
        Ingredient ingredient = new Ingredient(sauceType, sauceName, intPrice);
        String expectedName = "Кетчуп";
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);

    }

    @Test
    public void getFillingName() {
        Ingredient ingredient = new Ingredient(fillingType, fillingName, doublePrice);
        String expectedName = "Говядина";
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getSauceType() {
        Ingredient ingredient = new Ingredient(sauceType, fillingName, intPrice);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(SAUCE, actualIngredientType);
    }

    @Test
    public void getFillingType() {
        Ingredient ingredient = new Ingredient(fillingType, fillingName, intPrice);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(FILLING, actualIngredientType);
    }
}