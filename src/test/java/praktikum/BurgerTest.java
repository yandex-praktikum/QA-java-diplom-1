package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Spy
    private Burger burger = new Burger();

    public static final String BURGER_RECEIPT = "(==== бургер ====)" + System.lineSeparator() +
            "= filling начинка =" + System.lineSeparator() + "(==== бургер ====)" +
            System.lineSeparator() + System.lineSeparator() + "Price: 209,000000" + System.lineSeparator();

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(9f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = 209f;
        float actualPrice = burger.getPrice();
        assertEquals( "Некорректный результат",expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void burgerGetReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("бургер");
        Mockito.when(ingredient.getName()).thenReturn("начинка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(burger.getPrice()).thenReturn(209f);

        String expectedReceipt = BURGER_RECEIPT;
        String actualReceipt = burger.getReceipt();
        assertEquals("Некорректный результат", BURGER_RECEIPT, actualReceipt);
    }
}