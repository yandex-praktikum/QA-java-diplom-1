package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    Burger burger = new Burger();

    private final float bunPrice = 10;
    private final float ingredientPrice = 10;
    private final float expectedPrice = bunPrice * 2 + ingredientPrice;

    private final String expectedBunName = "black bun";
    private final String expectedIngredientName = "cutlet";
    private final IngredientType expectedIngredientType = IngredientType.FILLING;
    private final String expectedReceipt = String.format("(==== %s ====)%n", expectedBunName) +
            String.format("= %s %s =%n", expectedIngredientType.toString().toLowerCase(), expectedIngredientName) +
            String.format("(==== %s ====)%n", expectedBunName) +
            String.format("%nPrice: %f%n", expectedPrice);

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void getReceiptReturnCorrectReceipt() {
        Mockito.when(bun.getName()).thenReturn(expectedBunName);

        for (Ingredient ingredient : burger.ingredients) {
            Mockito.when(ingredient.getType()).thenReturn(expectedIngredientType);
            Mockito.when(ingredient.getName()).thenReturn(expectedIngredientName);
        }

        Mockito.when(burger.getPrice()).thenReturn(expectedPrice);

        String actualResult = burger.getReceipt();

        assertEquals(actualResult, expectedReceipt);
    }
}