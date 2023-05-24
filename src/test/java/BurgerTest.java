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

    private final static int INDEX = 0;
    private final static int NEW_INDEX = 1;
    private final static float EXPECTED_PRICE = 300;
    private final static String EXPECTED_RECEIPT = "(==== white bun ====)\n" +
                                                    "= sauce sour cream =\n" +
                                                    "= sauce sour cream =\n" +
                                                    "(==== white bun ====)\n" +
                                                    "\n" +
                                                    "Price: 400,000000\n";

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.bun, null);
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.ingredients.size(), 0);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.ingredients.size(), 0);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 1);
        burger.removeIngredient(INDEX);
        Assert.assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.ingredients.size(), 0);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 2);
        burger.moveIngredient(INDEX, NEW_INDEX);
        Assert.assertEquals(burger.ingredients.get(NEW_INDEX), burger.ingredients.get(INDEX));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.ingredients.size(), 0);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 1);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float actualPrice = burger.getPrice();
        Assert.assertEquals(EXPECTED_PRICE, actualPrice, 0.05);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.ingredients.size(), 0);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 2);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(EXPECTED_RECEIPT, actualReceipt);
    }
}
