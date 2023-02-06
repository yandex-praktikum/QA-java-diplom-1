package praktikum.burgerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {
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
    public void getReceiptNullBunNoIngredientsShowsNullBunAndReceiptPrice() {
        burger.setBuns(bunMock);

        String expectedReceipt = "(==== null ====)\n" + "(==== null ====)\n" + "\nPrice: 0,000000\n";
        String actualReceipt = burger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

    @Test
    public void getReceiptEmptyBunNoIngredientsShowsEmptyBunAndZeroReceiptPrice() {
        when(bunMock.getName()).thenReturn("");
        burger.setBuns(bunMock);

        String expectedReceipt = "(====  ====)\n" + "(====  ====)\n" + "\nPrice: 0,000000\n";
        String actualReceipt = burger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

    @Test
    public void getReceiptBunNoIngredientsShowsBunNameAndBurgerPrice() {
        Burger newBurger = spy(Burger.class);

        when(bunMock.getName()).thenReturn("red bun");
        newBurger.setBuns(bunMock);
        when(newBurger.getPrice()).thenReturn(100F);

        String expectedReceipt = "(==== red bun ====)\n" + "(==== red bun ====)\n" + "\nPrice: 100,000000\n";
        String actualReceipt = newBurger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

    @Test
    public void getReceiptBunAndIngredientsShowsBunNameIngredientsAndBurgerPrice() {
        Burger newBurger = spy(Burger.class);

        when(bunMock.getName()).thenReturn("red bun");
        newBurger.setBuns(bunMock);
        when(newBurger.getPrice()).thenReturn(100F);

        when(bunMock.getName()).thenReturn("red bun");

        when(ingredientMock1.getType()).thenReturn(FILLING);
        when(ingredientMock1.getName()).thenReturn("meat");

        when(ingredientMock2.getType()).thenReturn(SAUCE);
        when(ingredientMock2.getName()).thenReturn("mustard");

        newBurger.addIngredient(ingredientMock1);
        newBurger.addIngredient(ingredientMock2);

        String expectedReceipt = "(==== red bun ====)\n"
                + "= filling meat =\n"
                + "= sauce mustard =\n"
                + "(==== red bun ====)\n"
                + "\nPrice: 100,000000\n";

        String actualReceipt = newBurger.getReceipt().replace("\r", ""); //из-за разницы в сепараторах

        assertThat(expectedReceipt, equalTo(actualReceipt));

    }

}
