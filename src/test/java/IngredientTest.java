import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(SAUCE, "Терияки", 11.255F);
        assertEquals("Ошибка! Текущая цена отличается от ожидаемой", ingredient.price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(FILLING, "Салат", 11.223F);
        assertEquals("Ошибка! Имена ингредиентов не совпадают", ingredient.name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(FILLING, "Салат", 11.223F);
        assertEquals("Ошибка! Типы ингредиентов не совпадают", ingredient.type, ingredient.getType());
    }
}

