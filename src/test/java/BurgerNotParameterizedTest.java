import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerNotParameterizedTest {

    Burger burger;
    @Mock
    Bun bun;
    String burgerPrice;


    private final String fillingType = "cutlet";
    private final String sauceType = "hot sauce";
    private final Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    private final Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);


    @Before
    public void setUp(){
        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Mock bun");
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientToBurger() {
        burger.addIngredient(sauce);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== Mock bun ====)\n= sauce " +
                sauceType + " =\n(==== Mock bun ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }

    @Test
    public void moveBurgerIngredients() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== Mock bun ====)\n= filling " + fillingType + " =\n= sauce " +
                        sauceType + " =\n(==== Mock bun ====)\n\nPrice: " + burgerPrice + "\n",
                burger.getReceipt());
    }

    @Test
    public void removeBurgerIngredients() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        burger.addIngredient(filling);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== Mock bun ====)\n= filling " + fillingType + " =\n" +
                "(==== Mock bun ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }
}