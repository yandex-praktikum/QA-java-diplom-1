import org.junit.Assert;
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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;
    @Mock
    private Bun bun;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void correctValueOfBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientCorrectValueTest(){
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void burgerGetPriceTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        Mockito.doReturn(150f).when(bun).getPrice();
        Mockito.doReturn(100f).when(ingredient).getPrice();
        Mockito.doReturn(200f).when(ingredient2).getPrice();
        float actualPrice = burger.getPrice();
        float expectedPrice = 600;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void burgerGetReceiptTest(){
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.doReturn("Simple Bun").when(bun).getName();
        Mockito.doReturn(150f).when(bun).getPrice();
        Mockito.doReturn(IngredientType.FILLING).when(ingredient).getType();
        Mockito.doReturn("cutlet").when(ingredient).getName();
        Mockito.doReturn(100f).when(ingredient).getPrice();
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Simple Bun ====)\r\n= filling cutlet =\r\n(==== Simple Bun ====)\r\n\r\nPrice: 400,000000\r\n";
        Assert.assertEquals(expectedReceipt, actualReceipt);

    }
}
