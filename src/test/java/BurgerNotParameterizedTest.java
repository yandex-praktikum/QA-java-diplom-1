import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerNotParameterizedTest {

    Burger burger;
    Database database;
    @Mock
    Bun bun;
    List<Ingredient> ingredients;
    String burgerPrice;


    private final String fillingType = "cutlet";
    private final String sauceType = "hot sauce";
    private final int fillingIndex = 3;
    private final int sauceIndex = 0;


    @Before
    public void setUp(){
        database = new Database();
        ingredients = database.availableIngredients();
        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Mock bun");
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientToBurger() {
        burger.addIngredient(ingredients.get(sauceIndex));
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== Mock bun ====)\n= sauce " +
                sauceType + " =\n(==== Mock bun ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }

    @Test
    public void moveBurgerIngredients() {
        burger.addIngredient(ingredients.get(sauceIndex));
        burger.addIngredient(ingredients.get(fillingIndex));
        burger.moveIngredient(1, 0);
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== Mock bun ====)\n= filling " + fillingType + " =\n= sauce " +
                        sauceType + " =\n(==== Mock bun ====)\n\nPrice: " + burgerPrice + "\n",
                burger.getReceipt());
    }

    @Test
    public void removeBurgerIngredients() {
        burger.addIngredient(ingredients.get(sauceIndex));
        burger.removeIngredient(sauceIndex);
        burger.addIngredient(ingredients.get(fillingIndex));
        burgerPrice = new DecimalFormat("#0.000000").format(burger.getPrice());
        assertEquals("(==== Mock bun ====)\n= filling " + fillingType + " =\n" +
                "(==== Mock bun ====)\n\nPrice: " + burgerPrice + "\n", burger.getReceipt());
    }
}