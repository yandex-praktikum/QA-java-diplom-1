package praktikum.test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private final Ingredient ingredientSauce = new Ingredient(SAUCE, "Гречневая", 7f);

    @Test
    public void getPricePositiveResult() {
        float expected=7f;
        Assert.assertEquals("Некорректная цена", expected, ingredientSauce.getPrice(), 0);
    }

    @Test
    public void getNamePositiveResult() {
        assertEquals("Не та булочка", "Гречневая", ingredientSauce.getName());
    }

    @Test
    public void getTypePositiveResult() {
        Ingredient ingredientFilling = new Ingredient(FILLING, "Свежая", 9f);
        Assert.assertEquals(FILLING, ingredientFilling.getType());
    }
}