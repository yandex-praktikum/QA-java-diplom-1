import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTest {
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        assertEquals("Цена ингредиента не совпадает.",100, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("Название ингридиента не совпадает", "hot sauce", ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
        assertEquals("Тип ингридиента не совпадает.", IngredientType.FILLING, ingredient.getType());
    }
}
