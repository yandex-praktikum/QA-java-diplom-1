import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Ingredient ingridient1;
    private Ingredient ingridient2;
    private Bun bun;

    @Before
    public void setUp() throws Exception {
        ingridient1 = mock(Ingredient.class);
        when(ingridient1.getPrice()).thenReturn((float)100);
        when(ingridient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingridient1.getName()).thenReturn("hot sauce");

        ingridient2 = mock(Ingredient.class);
        when(ingridient2.getPrice()).thenReturn((float)100);
        when(ingridient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingridient2.getName()).thenReturn("cutlet");

        bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn((float)100);
        when(bun.getName()).thenReturn("white bun");
    }


    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingridient1);
        burger.addIngredient(ingridient2);

        float price = burger.getPrice();
        Assert.assertEquals(price, 400, TestConstants.delta);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingridient1);
        burger.addIngredient(ingridient2);

        String receipt = burger.getReceipt();
        Assert.assertEquals(receipt, "(==== white bun ====)\r\n= sauce hot sauce =\r\n= filling cutlet =\r\n(==== white bun ====)\r\n\r\nPrice: 400,000000\r\n");
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingridient1);
        burger.addIngredient(ingridient2);
        burger.removeIngredient(1);

        String receipt = burger.getReceipt();
        Assert.assertEquals(receipt, "(==== white bun ====)\r\n= sauce hot sauce =\r\n(==== white bun ====)\r\n\r\nPrice: 300,000000\r\n");
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingridient1);
        burger.addIngredient(ingridient2);
        burger.moveIngredient(1, 0);

        String receipt = burger.getReceipt();
        Assert.assertEquals(receipt, "(==== white bun ====)\r\n= filling cutlet =\r\n= sauce hot sauce =\r\n(==== white bun ====)\r\n\r\nPrice: 400,000000\r\n");
    }
}
