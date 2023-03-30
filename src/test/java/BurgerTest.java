import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;
import java.util.ArrayList;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Mock
    Bun bun;

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsAddCorrectBun() {
        Assert.assertEquals(burger.bun, null);
        bun = new Bun("bun", 20.20f);
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun.getName(), "bun");
        Assert.assertEquals(burger.bun.getPrice(), 20.20f, 0);
    }

    @Test
    public void addIngredientCreatesIngredient() {
        Assert.assertTrue(burger.ingredients.isEmpty());
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientDeleteIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMovesIngredients() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Ingredient objIngredient1 = burger.ingredients.get(0);
        Ingredient objIngredient2 = burger.ingredients.get(1);
        Assert.assertEquals(objIngredient1, burger.ingredients.get(0));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(objIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Mockito.when(bun.getPrice()).thenReturn(10.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(1.00f);
        Burger burger = new Burger(bun, new ArrayList<>());
        burger.addIngredient(ingredient);
        Assert.assertEquals(21.00f, burger.getPrice(), 0);
    }

    @Test
    public void getRecieptReturnsCorrectValue() {
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(20.00f);
        Mockito.when(bun.getPrice()).thenReturn(20.00f);
        Burger burger = new Burger(bun, new ArrayList<>());
        burger.addIngredient(ingredient);
        String expected = "(==== bun ====)\r\n" +
                "= sauce ingredient =\r\n" +
                "(==== bun ====)\r\n" +
                "\r\n" +
                "Price: 60,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
