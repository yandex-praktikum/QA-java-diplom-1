package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestIngredient {
    static DataManager ingredientData = new DataManager();
    private final String commonName;
    private final float commonPrice;
    private final IngredientType ingredientType;

    public TestIngredient(IngredientType ingredientType, String commonName, float commonPrice) {
        this.ingredientType = ingredientType;
        this.commonName = commonName;
        this.commonPrice = commonPrice;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {IngredientType.SAUCE, ingredientData.getAnyString(), ingredientData.getAnyFloat()},
                {IngredientType.SAUCE, "", ingredientData.getAnyFloat()},
                {IngredientType.SAUCE, " ", ingredientData.getAnyFloat()},
                {IngredientType.SAUCE, null, ingredientData.getAnyFloat()},
                {IngredientType.SAUCE, ingredientData.getAnyString(), Float.MAX_VALUE},
                {IngredientType.SAUCE, "", Float.MAX_VALUE},
                {IngredientType.SAUCE, " ", Float.MAX_VALUE},
                {IngredientType.SAUCE, null, Float.MAX_VALUE},
                {IngredientType.SAUCE, ingredientData.getAnyString(), Float.MIN_VALUE},
                {IngredientType.SAUCE, "", Float.MIN_VALUE},
                {IngredientType.SAUCE, " ", Float.MIN_VALUE},
                {IngredientType.SAUCE, null, Float.MIN_VALUE},
                {IngredientType.FILLING, ingredientData.getAnyString(), ingredientData.getAnyFloat()},
                {IngredientType.FILLING, "", ingredientData.getAnyFloat()},
                {IngredientType.FILLING, " ", ingredientData.getAnyFloat()},
                {IngredientType.FILLING, null, ingredientData.getAnyFloat()},
                {IngredientType.FILLING, ingredientData.getAnyString(), Float.MAX_VALUE},
                {IngredientType.FILLING, "", Float.MAX_VALUE},
                {IngredientType.FILLING, " ", Float.MAX_VALUE},
                {IngredientType.FILLING, null, Float.MAX_VALUE},
                {IngredientType.FILLING, ingredientData.getAnyString(), Float.MIN_VALUE},
                {IngredientType.FILLING, "", Float.MIN_VALUE},
                {IngredientType.FILLING, " ", Float.MIN_VALUE},
                {IngredientType.FILLING, null, Float.MIN_VALUE},
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, commonName, commonPrice);
        IngredientType actualType = ingredient.getType();
        assertEquals(ingredientType, actualType);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, commonName, commonPrice);
        String actualName = ingredient.getName();
        assertEquals(commonName, actualName);
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, commonName, commonPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals(commonPrice, actualPrice, 0.001);
    }

}