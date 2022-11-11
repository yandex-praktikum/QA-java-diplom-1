import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Spy
    Burger burger;

    public static final String RECEIPT =
            "(==== Нижегородская ====)" + System.lineSeparator() + "= filling сиба-ину ="
            + System.lineSeparator() + "(==== Нижегородская ====)" + System.lineSeparator()
            + System.lineSeparator() + "Price: 100,000000" + System.lineSeparator();

    @Test
    public void getRecieptTest() {
        Mockito.when(bun.getName()).thenReturn("Нижегородская");
        Mockito.when(ingredient.getName()).thenReturn("сиба-ину");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.doReturn(100F).when(burger).getPrice();
        Assert.assertEquals(RECEIPT, burger.getReceipt());
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredient.getPrice()).thenReturn(98F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(100F, burger.getPrice(), 0);
    }

}