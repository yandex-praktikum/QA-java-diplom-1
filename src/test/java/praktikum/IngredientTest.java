package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @ParameterizedTest
    @ValueSource(floats = {0, -100.34f, 300.79f})
    public void getPriceIngredientTest(float price) {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "name", price);
        float actual = ingredient.getPrice();
        float expected = ingredient.price;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "test string", "test string @_%ч,."})
    public void getNameIngredientTest(String name) {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, 100);
        String actual = ingredient.getName();
        String expected = ingredient.name;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    public void getTypeIngredientTest(IngredientType type) {
        Ingredient ingredient = new Ingredient(type, "name", 100);
        IngredientType actual = ingredient.getType();
        IngredientType expected = ingredient.type;
        assertEquals(expected, actual);
    }
}