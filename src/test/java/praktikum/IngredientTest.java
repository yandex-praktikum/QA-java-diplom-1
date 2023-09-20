package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;

    @Test
    public void getName_ShouldReturn_ExpectedName() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Барбекю", 5.5f);
        String expectedName = "Барбекю";
        assertEquals("Наименования не совпадают", expectedName, ingredient.getName());
    }

    @Test
    public void getPrice_ZeroDelta_ShouldReturnEqualPrice() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Томатный", 5.5f);
        float expectedPrice = 5.5f;
        assertEquals("Значения ожидаемой и актуальной цен не равны", expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getPrice_NotPermissibleDelta_ShouldReturnDifferentPrice() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Майонез", 3.5f);
        float expectedPrice = 1.5f;
        float actualPrice = ingredient.getPrice();
        assertNotEquals(expectedPrice, actualPrice, 1.5);
    }

    @Test
    public void getType() {
        ingredient = new Ingredient(IngredientType.FILLING, "Овощи", 2.25f);
        IngredientType expectedType = IngredientType.FILLING;
        assertEquals("Тип ингредиента не совпадает", expectedType, ingredient.getType());
    }
}
