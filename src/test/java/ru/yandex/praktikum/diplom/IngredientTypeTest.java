package ru.yandex.praktikum.diplom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    public String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.TEST_DATA_FOR_INGREDIENT_TYPE_TEST;
    }

    @Test
    public void IngredientTypeIsСontainsTypePositiveResult() {
        String expected = type;
        try {
            IngredientType.valueOf(type);
        } catch (Exception exception) {
            String actual = "IngredientType не соидержит тип " + type;
            assertEquals("IngredientType не соидержит тип " + type, expected, actual);
        }
    }
}
