import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void verifyBurgerGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100.01f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(10.01f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(230.05, burger.getPrice(), 0.001);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    public void verifygetReceiptTest(){
        String receipt = "(==== bulka ====)\r\n" +
                "= sauce ingredient01 =\r\n" +
                "= sauce ingredient01 =\r\n" +
                "= sauce ingredient01 =\r\n" +
                "(==== bulka ====)\r\n" +
                "\r\n" +
                "Price: 230,000000"+ "\r\n";

        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("bulka");
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getName()).thenReturn("ingredient01");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(receipt, burger.getReceipt());
    }
}
