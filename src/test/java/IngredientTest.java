import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    Random random = new Random();
    private final String testName = "Test Name";
    private final float testPrice = 0 + random.nextFloat() * 100;
    float comparisonDelta = testPrice / 100;
    String errorMessageConstructorNameTest = "Конструктор передает неверное имя";
    String errorMessageConstructorPriceTest = "Конструктор передает неверную цену";
    String errorMessageConstructorIngredientTypeTest = "Конструктор передает неверный IngredientType";

    @Test
    public void isIngredientConstructorSetsCorrectIngredientTypeAndNameAndPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, testName, testPrice);
        String expectedName = testName;
        String actualName = ingredient.name;
        float expectedPrice = testPrice;
        float actualPrice = ingredient.price;
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        IngredientType actualIngredientType = ingredient.type;
        boolean isIngredientTypeCorrect = expectedIngredientType == actualIngredientType;
        assertEquals(errorMessageConstructorIngredientTypeTest, true, isIngredientTypeCorrect);
        assertEquals(errorMessageConstructorNameTest, expectedName, actualName);
        assertEquals(errorMessageConstructorPriceTest, expectedPrice, actualPrice, comparisonDelta);
    }

    @Test
    public void isGetPriceReturnsCorrectPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, testName, testPrice);
        float expectedPrice = testPrice;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, comparisonDelta);
    }

    @Test
    public void isGetNameReturnsCorrectNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, testName, testPrice);
        String expectedName = testName;
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void isGetIngredientTypeReturnsCorrectIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, testName, testPrice);
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        IngredientType actualIngredientType = ingredient.getType();
        boolean isIngredientTypeCorrect = expectedIngredientType == actualIngredientType;
        assertEquals(errorMessageConstructorIngredientTypeTest, true, isIngredientTypeCorrect);
    }
}
