package praktikum.tests;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngridientTest {
    IngredientType type = IngredientType.FILLING;
    String name = "sausage";
    float price = 300F;
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

}
