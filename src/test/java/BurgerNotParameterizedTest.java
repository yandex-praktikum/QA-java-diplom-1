import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerNotParameterizedTest {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient sauce;
    @Mock
    Ingredient filling;
    String burgerPrice;


    private final String sauceName = "hot sauce";
    private final String fillingName = "cutlet";
    private final String bunName = "Mock bun";


    @Before
    public void setUp(){
        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(sauce.getType()).thenReturn(SAUCE);
        Mockito.when(sauce.getName()).thenReturn(sauceName);
        Mockito.when(sauce.getPrice()).thenReturn(100F);
        Mockito.when(filling.getType()).thenReturn(FILLING);
        Mockito.when(filling.getName()).thenReturn(fillingName);
        Mockito.when(filling.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientToBurger() {
        burger.addIngredient(sauce);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== " + bunName + " ====)\n= sauce " +
                sauceName + " =\n(==== " + bunName + " ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }

    @Test
    public void moveBurgerIngredients() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== " + bunName + " ====)\n= filling " + fillingName + " =\n= sauce " +
                        sauceName + " =\n(==== " + bunName + " ====)\n\nPrice: " + burgerPrice + "\n",
                burger.getReceipt());
    }

    @Test
    public void removeBurgerIngredients() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        burger.addIngredient(filling);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== " + bunName + " ====)\n= filling " + fillingName + " =\n" +
                "(==== " + bunName + " ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }
}