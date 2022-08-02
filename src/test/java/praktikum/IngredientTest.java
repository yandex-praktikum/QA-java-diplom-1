package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private final String EXPECTED_NAME = "Чесночный соус";
    private final float EXPECTED_PRICE = 2.22F;
    private Ingredient ingredient;

    @Mock
    private IngredientType type;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, EXPECTED_NAME, EXPECTED_PRICE);
    }

    @Test
    public void getTypeOfIngredient() {
        assertEquals("Неправильный тип ингредиента", ingredient.getType(), type);
    }

    @Test
    public void getNameOfIngredient() {
        String actualNameOfIngredient = ingredient.getName();
        assertEquals("Неправильное имя ингредиента", actualNameOfIngredient, EXPECTED_NAME);
    }

    @Test
    public void getPriceOfIngredient() {
        float actualPriceOfIngredient = ingredient.getPrice();
        assertEquals("Неправильная цена ингредиента", actualPriceOfIngredient, EXPECTED_PRICE, 0);
    }
}
