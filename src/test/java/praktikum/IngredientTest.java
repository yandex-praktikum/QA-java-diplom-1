package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    IngredientType anyIngredientType;
    String anyName;
    float anyPrice;

    IngredientType testType = IngredientType.FILLING;
    String testName = "testName";
    float testPrice = 111;

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(testType, anyName, anyPrice);
        IngredientType expectedResult = IngredientType.FILLING;
        IngredientType actualResult = ingredient.getType();
        System.out.println(ingredient.getPrice());
        assertEquals("getIngredientType method (class Ingredient) doesn't work", expectedResult, actualResult);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(anyIngredientType, testName, anyPrice);
        String expectedResult = "testName";
        String actualResult = ingredient.getName();
        assertEquals("getName method (class Ingredient) doesn't work", expectedResult, actualResult);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(anyIngredientType, anyName, testPrice);
        float expectedResult = 111;
        float actualResult = ingredient.getPrice();
        assertEquals("getPrice method (class Ingredient) doesn't work", expectedResult, actualResult, 0);
    }

}
