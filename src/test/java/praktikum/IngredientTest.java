package praktikum;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Юнит-тесты класса Ingredient
 */
public class IngredientTest {
    // Создаем тестовые данные со случайными значениями
    public float actualPrice = new Random().nextFloat();
    public String actualName = "KolyaevBun" + new Random().nextInt(10);
    IngredientType type = IngredientType.values()[new Random().nextInt(IngredientType.values().length)];

    // Проверяем что геттер GetPrice возвращает цену ингредиента
    @Test
    public void checkGetPriceReturnsFloatFromParameters() {
        Ingredient ingredient = new Ingredient(type, actualName, actualPrice);
        float expectedPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    // Проверяем что геттер GetName возвращает названия ингредиента
    @Test
    public void checkGetNameReturnsStringFromParameters() {
        Ingredient ingredient = new Ingredient(type, actualName, actualPrice);
        String expectedName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }
}
