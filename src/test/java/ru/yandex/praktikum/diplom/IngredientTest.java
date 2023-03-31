package ru.yandex.praktikum.diplom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    public String type;
    public String name;
    public float price;

    @Mock
    IngredientType mockedIngredientType;

    public IngredientTest(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.TEST_DATA_FOR_INGREDIENT_TEST;
    }

    private IngredientType returnType(String type) {
        if (type == "SAUCE") {
            return IngredientType.SAUCE;
        }
        return IngredientType.FILLING;
    }

    @Test
    public void getNameReturnName() {
        Ingredient ingredient = new Ingredient(returnType(type), name, price);
        String expected = name;
        String actual = ingredient.getName();
        assertEquals("Неверное название", expected, actual);
    }

    @Test
    public void getNameReturnPrice() {
        Ingredient ingredient = new Ingredient(returnType(type), name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals("Неверная цена", expected, actual, 0);
    }

    @Test
    public void getTypeReturnType() {
        Ingredient ingredient = new Ingredient(returnType(type), name, price);
        IngredientType expected = returnType(type);
        IngredientType actual = ingredient.getType();
        assertEquals("Неверный тип", expected, actual);
    }
}
