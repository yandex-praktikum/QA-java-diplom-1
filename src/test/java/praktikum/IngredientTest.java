package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void createNewInstance() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15.0f);
    }
    @Test
    public void getPriceTest() {
        assertEquals( ingredient.getPrice(), 15.0f, 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(ingredient.name, "Соус традиционный галактический");
    }

}