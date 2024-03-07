import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80);
        assertEquals(80, ingredient.getPrice(), 0.00001);
    }

    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80);
        assertEquals("Соус фирменный Space Sauce", ingredient.getName());
    }

    @Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

}
