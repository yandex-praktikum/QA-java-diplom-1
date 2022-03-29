import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    public Ingredient createIngredient() {
        return new Ingredient(IngredientType.SAUCE, "Соус", (float) 120.5);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = createIngredient();
        float expected = ingredient.price;

        float actual = ingredient.getPrice();

        assertEquals("Цены не совпадают", expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = createIngredient();
        String expected = ingredient.name;

        String actual = ingredient.getName();

        assertEquals("Имена не совпадают", expected, actual);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = createIngredient();
        IngredientType expected = ingredient.type;

        IngredientType actual = ingredient.getType();

        assertEquals("Типы ингредиентов не совпадают", expected, actual);
    }
}
