import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(30F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(230, burger.getPrice(), 0);
    }

    @Test
    public void burgerGetReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("булка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("соус");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        System.out.println(burger.getReceipt());
        String expected = "(==== булка ====)\r\n" + "= sauce соус =\r\n" + "(==== булка ====)\r\n" + "\r\n" + "Price: 0,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }

}