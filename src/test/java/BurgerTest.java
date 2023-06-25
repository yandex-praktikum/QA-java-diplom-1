import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Test
    public void testSetBun() {
        burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(20.11f);
        Mockito.when(ingredient.getPrice()).thenReturn(30.22f);
        Mockito.when(ingredient2.getPrice()).thenReturn(40.33f);
        float expectedPrice = 110.77f;
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void testGetReceipt() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("bun111");
        Mockito.when(bun.getPrice()).thenReturn(1255.00f);
        Mockito.when(ingredient.getName()).thenReturn("Sauce222");
        Mockito.when(ingredient.getPrice()).thenReturn(90.00f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("cutlet333");
        Mockito.when(ingredient2.getPrice()).thenReturn(874.00f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        String expected = "(==== bun111 ====)\n" +
                "= sauce Sauce222 =\n" +
                "= filling cutlet333 =\n" +
                "(==== bun111 ====)\n" +
                "\n" +
                "Price: 3474,000000\n";
        Assert.assertEquals(expected.replace("\r\n", "\n"), burger.getReceipt().replace("\r\n", "\n"));
    }

}
