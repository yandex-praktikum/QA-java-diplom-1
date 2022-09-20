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

    private final float bunPrice = 50F;
    private final float ingredientPrice = 10F;
    private final float expectedPrice = bunPrice * 2 + ingredientPrice;

    private final String expectedBunName = "red bun";
    private final String expectedIngredientName = "sausage";
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
    public void getReceiptReturnsCorrectReceipt() {
        Mockito.when(bun.getName()).thenReturn(expectedBunName);

        for (Ingredient ingredient : burger.ingredients) {
            Mockito.when(ingredient.getName()).thenReturn(expectedIngredientName);
            Mockito.when(ingredient.getType()).thenReturn(expectedIngredientType);

        }

        Mockito.when(burger.getPrice()).thenReturn(expectedPrice);

        String actualResult = burger.getReceipt();

        assertEquals("The actual receipt is not equals to expected", expectedReceipt, actualResult);
    }

}
