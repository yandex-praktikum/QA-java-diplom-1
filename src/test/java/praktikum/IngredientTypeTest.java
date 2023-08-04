package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void checkIngredientTypesNumber() {
        // Arrange
        int expectedNumberOfIngredientsType = 2;
        // Act
        int actualNumberOfIngredientsType = IngredientType.values().length;
        // Assert
        Assert.assertEquals(expectedNumberOfIngredientsType, actualNumberOfIngredientsType);
    }

    @Test
    public void isSauceIngredientType() {
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void isFillingIngredientType() {
        Assert.assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}