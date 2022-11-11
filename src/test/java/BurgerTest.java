import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

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
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunCorrectValueTest() {
        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsValueCorrectly() {
        burger.addIngredient(ingredient);

        Assert.assertEquals( 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientCorrectlyTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertTrue( burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMovesTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);

        Assert.assertEquals( ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnValueTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);

        Mockito.doReturn(100F).when(bun).getPrice();
        Mockito.doReturn(100F).when(ingredient).getPrice();
        Mockito.doReturn(300F).when(ingredient2).getPrice();
        float actualResult = burger.getPrice();
        float expectedResult = 600;

        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptReturnCorrectValue() {
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        Mockito.doReturn("bunTest").when(bun).getName();
        Mockito.doReturn(100F).when(bun).getPrice();
        Mockito.doReturn(IngredientType.FILLING).when(ingredient).getType();
        Mockito.doReturn("sausage").when(ingredient).getName();
        Mockito.doReturn(100F).when(ingredient).getPrice();
        String actualResult = burger.getReceipt();
        String expectedResult = "(==== bunTest ====)\r\n= filling sausage =\r\n(==== bunTest ====)\r\n\r\nPrice: 300,000000\r\n";

        Assert.assertEquals(expectedResult, actualResult);
    }
}