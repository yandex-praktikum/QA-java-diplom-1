import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals("Метод должен возвращать строку sour cream", "sour cream", ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals("Метод должен возвращать цену 200", 200, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals("Метод должен возвращать тип Соус", IngredientType.SAUCE, ingredient.getType());
    }
}