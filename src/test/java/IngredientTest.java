import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;


public class IngredientTest {

    final IngredientType type = SAUCE;
    final String name = "Test name";
    final float price = (float) 1.1;

    @Test
    public void TestGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assert ingredient.getPrice() == price;
    }
    @Test
    public void TestGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assert ingredient.getName().equals(name);
    }
    @Test
    public void TestGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assert ingredient.getType().equals(type);
    }
}