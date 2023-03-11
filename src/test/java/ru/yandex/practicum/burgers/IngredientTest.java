package ru.yandex.practicum.burgers;

import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    final IngredientType type;
    final String name;
    final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100F},
                {IngredientType.FILLING, "dinosaur", 200F},
        };
    }

    @Test
    public void doesGetTypeReturnValidValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType  = ingredient.getType();
        assertEquals("Тип ингредиента отличается:", actualType, type);
    }

    @Test
    public void doesGetNameReturnValidValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName  = ingredient.getName();
        assertEquals("Название ингредиента отличается:", actualName, name);
    }

    @Test
    public void doesGetPriceReturnValidValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice  = ingredient.getPrice();
        assertEquals("Стоимость ингредиента отличается:", actualPrice, price, 0.05);
    }
}
