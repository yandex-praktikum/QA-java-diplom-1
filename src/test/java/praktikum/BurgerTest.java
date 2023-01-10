package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void getPriceCalculatesPriceCorrectly() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expectedPrice = 500F;
        MatcherAssert.assertThat("There is problem in price calculations",
                burger.getPrice(),
                equalTo(expectedPrice));
    }

    @Test
    public void getReceiptCreatesCorrectReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        String expectedReceipt = "(==== white bun ====)\n= filling cutlet =\n(==== white bun ====)\n\nPrice: 0.000000\n";
        MatcherAssert.assertThat("There is problem in receipt",
                burger.getReceipt(),
                equalTo(expectedReceipt));
    }
}