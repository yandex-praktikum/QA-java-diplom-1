package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final String name = "";
    private final float price = 15;
    private Ingredient ingredient;

    @Mock
    IngredientType ingredientType;

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPriceOfTheIngredient() {
        assertEquals("Цена ингредиента", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameOfTheIngredient() {
        assertEquals("Наименование ингредиента", name, ingredient.getName());
    }
}
