package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;

    @Before // создаем ингредиент передкаждым тестом
    public void setup() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Томатный соус", 30);
    }

    @Test // проверка получения стоимости ингредиента
    public void shouldReturnPrice() {
        float expected = 30;
        assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test  // проверка получения названия ингредиента
    public void shouldReturnName() {
        String expected = "Томатный соус";
        assertEquals(expected, ingredient.getName());
    }
}