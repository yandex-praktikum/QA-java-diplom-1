package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    void testSauceConstructor() {
        final String name = "foo";
        final float price = 10.0f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        assertEquals(IngredientType.SAUCE, ingredient.type);
        assertEquals(IngredientType.SAUCE, ingredient.getType());

        assertEquals(name, ingredient.name);
        assertEquals(name, ingredient.getName());

        assertEquals(price, ingredient.price);
        assertEquals(price, ingredient.getPrice());
    }

    @Test
    void testFillingConstructor() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "foo", 10.0f);

        assertEquals(IngredientType.FILLING, ingredient.type);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
