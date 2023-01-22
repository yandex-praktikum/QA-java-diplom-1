package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private Database database;

    @Mock
    Bun bunMock;
    @Mock
    Ingredient sauceMock;
    @Mock
    Ingredient fillingMock;

    @Before
    public void setUp(){
        burger = new Burger();
        database = new Database();
    }

    @Test
    public void addIngredientBurgerTest(){
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(0));
        int expected = 1;
        int actual = burger.ingredients.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientBurgerTest(){
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        int expected = 0;
        int actual = burger.ingredients.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientBurgerTest(){
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(2));
        burger.moveIngredient(0, 1);
        String expected = "hot sauce";
        String actual = burger.ingredients.get(1).getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bunMock);
        burger.addIngredient(sauceMock);
        Mockito.when(bunMock.getName()).thenReturn("blue bun");
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        Mockito.when(sauceMock.getName()).thenReturn("sour cream");
        Mockito.when(sauceMock.getPrice()).thenReturn(200F);
        Mockito.when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);
        StringBuilder receipt = new StringBuilder();
        receipt.append("(==== blue bun ====)\n");
        receipt.append("= sauce sour cream =\n");
        receipt.append("(==== blue bun ====)\n\n");
        receipt.append("Price: 400.000000\n");
        String expected = receipt.toString();
        String actual = burger.getReceipt().toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bunMock);
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
        Mockito.when(bunMock.getPrice()).thenReturn(300f);
        Mockito.when(sauceMock.getPrice()).thenReturn(200f);
        Mockito.when(fillingMock.getPrice()).thenReturn(100f);
        float expected = 900f;
        float actual = burger.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

}
