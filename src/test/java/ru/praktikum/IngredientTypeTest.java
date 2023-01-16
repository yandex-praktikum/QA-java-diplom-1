package ru.praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getDataIngredientType(){
        return new Object[][] {
                {"FILLING"},
                {"SAUCE"},
        };
    }

    // провереряем что в перечеслении IngredientType содержатся константы перечисления FILLING и SAUCE
    @Test
    public void getIngredientTypeCorrectValue(){
        Assert.assertNotNull(IngredientType.valueOf(ingredientType));

    }
}
