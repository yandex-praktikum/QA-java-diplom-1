import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
//basic getters so there is no need for mocks or stubs.
    @Test
    public void testGetPrice() {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 30f);
        float expectedResult = 30f;

        // Act
        float actualResult = ingredient.getPrice();

        // Assert
        assertEquals("The price of the ingredient should match the expected result.", expectedResult, actualResult, 0.01);
    }

    @Test
    public void testGetName() {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 30f);
        String expectedResult = "Ketchup";

        // Act
        String actualResult = ingredient.getName();

        // Assert
        assertEquals("The name of the ingredient should match the expected result.", expectedResult, actualResult);
    }

    @Test
    public void testGetType() {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 30f);
        IngredientType expectedResult = IngredientType.SAUCE;

        // Act
        IngredientType actualResult = ingredient.getType();

        // Assert
        assertEquals("The type of the ingredient should match the expected result.", expectedResult, actualResult);
    }
}
