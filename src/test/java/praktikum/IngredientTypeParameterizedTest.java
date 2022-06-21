package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private final Ingredient ingredient;
    private final IngredientType expectedType;


    public IngredientTypeParameterizedTest(Ingredient ingredient, IngredientType expectedType) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters (name = "{index}: IngredientType {1}")
    public static Object[][] sourceOfData (){
        return new Object[][]{
                {new Ingredient (IngredientType.FILLING, "Вкусная котлета", 100F), IngredientType.FILLING},
                {new Ingredient (IngredientType.SAUCE, "Невкусный соус", 10F), IngredientType.SAUCE},
                {new Ingredient (null, "Невкусный соус", 10F), null}
        };
    }
    // проверка для всех значений перечисления - SAUCE и FILLING, а также null
    @Test
    public void testIngredientType(){
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Error in type of ingredient", expectedType, actualType);
    }
}

