package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "name", 10);
    }

    @Test
    public void testIngredientGetPrice() {
        assertEquals(10, ingredient.getPrice(), 0);
    }

    @Test
    public void testIngredientGetName() {
        assertEquals("name", ingredient.getName());
    }

    @Test
    public void testIngredientGetTypeSauce() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test(expected = Exception.class)
    public void testIngredientTypeIsNullValueExpectedException() {
        try {
            ingredient = new Ingredient(null, "name", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(expected = Exception.class)
    public void testNameIsNullValueExpectedException() {
        try {
            ingredient = new Ingredient(IngredientType.SAUCE, null, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(expected = Exception.class)
    public void testNameIsEmptyValueExpectedException() {
        try {
            ingredient = new Ingredient(IngredientType.SAUCE, "", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(expected = Exception.class)
    public void testPriceIsNegativeExpectedException() {
        try {
            ingredient = new Ingredient(IngredientType.SAUCE, "name", -10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}