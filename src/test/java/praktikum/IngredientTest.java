package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE,"name", 10);
    }
    @Test
    public void testIngredientgetPrice() {
        assertEquals(10, ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
        assertEquals("name", ingredient.getName());
    }

    @Test
    public void getTypeSauce() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
    @Test
    public void TypeIsNullValue() {
        ingredient = new Ingredient(null,"name", 10);

    }

}