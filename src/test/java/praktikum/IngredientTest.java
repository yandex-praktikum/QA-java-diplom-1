package praktikum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        assertEquals("Метод должен возвращать строку hot sauce", "hot sauce", ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cutlet", 100f);
        assertEquals("Метод должен возвращать цену 100", 100, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200f);
        assertEquals("Метод должен возвращать тип Соус", IngredientType.SAUCE, ingredient.getType());
    }
}