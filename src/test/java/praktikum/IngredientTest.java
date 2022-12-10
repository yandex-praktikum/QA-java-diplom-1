package praktikum;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static praktikum.Generator.*;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {

    Ingredient ingredientTest;

    @Before
    public void setUp() {
        ingredientTest = Generator.getDefaultIngredient();
    }

    @Test
    public void getPriceReturnsValidValue() {
        Assert.assertEquals("Некорректная возвращаемая цена",
                INGREDIENT_TEST_PRICE, ingredientTest.getPrice(), 0.0);
    }

    @Test
    public void getNameReturnsValidValue() {
        Assert.assertEquals("Некорректное возвращаемое имя",
                INGREDIENT_TEST_NAME, ingredientTest.getName());
    }

    @Test
    public void getTypeReturnsValidValue() {
        Assert.assertEquals("Некорректный возвращаемый тип",
                INGREDIENT_TEST_TYPE, ingredientTest.getType());
    }
}