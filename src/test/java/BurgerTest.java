import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    String expectedReceipt1 =
            "(==== Булочка с кунжутом ====)\n" +
            "= sauce Кетчунез =\n" +
            "(==== Булочка с кунжутом ====)\n" +
            "\n" +
            "Price: 30,666000" +
            "\n";

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void getPriceReturnsExpectedValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(10.3300F);
        Mockito.when(ingredient.getPrice()).thenReturn(10.0060F);
        float expectedPrice  = 30.6660F;

        assertEquals(expectedPrice, burger.getPrice());
    }

    @Test
    public void getReceiptReturnsExpectedValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(10.3300F);
        Mockito.when(ingredient.getPrice()).thenReturn(10.0060F);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Кетчунез");

        assertEquals(expectedReceipt1, burger.getReceipt());
    }

}
