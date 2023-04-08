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
    Ingredient ingredientOne, ingredientTwo, ingredientThree;;
    @Spy
    private Burger burger = new Burger();

    public static final String BURGER_RECEIPT = "(==== бургер ====)" + System.lineSeparator() +
            "= filling начинка =" + System.lineSeparator() + "(==== бургер ====)" +
            System.lineSeparator() + System.lineSeparator() + "Price: 209,000000" + System.lineSeparator();

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(9f);
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        float expectedPrice = 209f;
        float actualPrice = burger.getPrice();
        assertEquals( "Некорректный результат",expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void burgerGetReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("бургер");
        Mockito.when(ingredientOne.getName()).thenReturn("начинка");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);

        Mockito.when(burger.getPrice()).thenReturn(209f);

        String actualReceipt = burger.getReceipt();
        assertEquals("Некорректный результат", BURGER_RECEIPT, actualReceipt);
    }
    @Test
    public void burgerRemoveIngredientTest () {

        Burger burger = new Burger ();
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);

        assertEquals(true, burger.ingredients.isEmpty());
    }
    @Test
    public void burgerMoveIngredientTest () {

        Burger burger = new Burger ();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        burger.moveIngredient(0,2);

        assertEquals(ingredientOne, burger.ingredients.get(2));
    }
}