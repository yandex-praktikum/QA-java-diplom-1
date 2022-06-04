package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

/**
 * Author: Alexey Bondarenko
 * Date: 03.06.2022
 */
@RunWith(Parameterized.class)
public class IngredientConstructorParametrizedTest {


    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    private final String expectedResult;


    public IngredientConstructorParametrizedTest(List<Object> data, String expectedResult) {
        this.expectedType = (IngredientType) data.get(0);
        this.expectedName = (String) data.get(1);
        this.expectedPrice = (Float) data.get(2);
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {List.of(SAUCE, "", 5F), "Error message"}, // Баг, нельзя создать ингридиент с пустыми именем
                {List.of(SAUCE, " ", 5F), "Error message"}, // Баг, нельзя создать ингридиент лишь с пробелами в имени
                {List.of(SAUCE, "z\\xd0\\", 5F), ""}, // Уточнил бы тут
                {List.of(SAUCE, "!№;%:?*():eagle:", 5F), ""}, // Уточнил бы тут
                {List.of(FILLING, "Cheese", -1F), ""}, // Баг, нельзя задавать отрицательное число
        };
    }

    @Test
    public void checkConstructorForIngredient() {
        try {
            new Ingredient(expectedType, expectedName, expectedPrice);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(expectedResult, e.getMessage());
        }
    }


}
