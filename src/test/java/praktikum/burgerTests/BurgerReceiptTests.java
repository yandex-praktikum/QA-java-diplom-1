package praktikum.burgerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTests {
    Burger burger = new Burger();
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock1;
    @Mock
    private Ingredient ingredientMock2;

    @Test(expected = NullPointerException.class)
    public void getReceiptNullShowsNullPointerException() {
        burger.getReceipt();
    }

    @Test
    public void getReceiptBunNullNoIngredientsShowsEmptyReceipt() {
        burger.setBuns(bunMock);

        String expectedReceipt = "(==== null ====)\n" + "(==== null ====)\n" + "\nPrice: 0,000000\n";
        String actualReceipt = burger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

    @Test
    public void getReceiptBunNoIngredientsShowsBunNameAndBurgerPriceInReceipt() {
        burger.setBuns(bunMock);

        Mockito.when(bunMock.getPrice()).thenReturn(0.00F);
        Mockito.when(bunMock.getName()).thenReturn("red bun");

        String expectedReceipt = "(==== red bun ====)\n" + "(==== red bun ====)\n" + "\nPrice: 0,000000\n";
        String actualReceipt = burger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

    @Test
    public void getReceipt() {

        Mockito.when(bunMock.getPrice()).thenReturn(0.00F);
        Mockito.when(bunMock.getName()).thenReturn("red bun");

        Mockito.when(ingredientMock1.getType()).thenReturn(FILLING);
        Mockito.when(ingredientMock1.getName()).thenReturn("meat");
        Mockito.when(ingredientMock1.getPrice()).thenReturn(5.05F);

        Mockito.when(ingredientMock2.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientMock2.getName()).thenReturn("mustard");
        Mockito.when(ingredientMock2.getPrice()).thenReturn(4.05F);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);


        String expectedReceipt = "(==== red bun ====)\n"
                + "= filling meat =\n"
                + "= sauce mustard =\n"
                + "(==== red bun ====)\n"
                + "\nPrice: 9,100000\n";

        String actualReceipt = burger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

}
