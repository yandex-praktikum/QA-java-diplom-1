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
public class BurgerMockTest {
    Burger burger;
    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient sausage;
    @Mock
    Ingredient hotSauce;
    @Mock
    Bun bun;
    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(cutlet);
        burger.addIngredient(sausage);
        burger.addIngredient(hotSauce);
        burger.setBuns(bun);
    }
    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Assert.assertEquals(2, burger.ingredients.size());
    }
    @Test
    public void checkGetPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(cutlet.getPrice()).thenReturn(100f);
        Mockito.when(sausage.getPrice()).thenReturn(100f);
        Mockito.when(hotSauce.getPrice()).thenReturn(100f);
        Assert.assertEquals(500f, burger.getPrice(), 0.0f);
    }
    @Test
    public void addIngredientTest() {
        Assert.assertEquals(3, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 1);
        Assert.assertEquals(3, burger.ingredients.size());
        Assert.assertEquals(sausage, burger.ingredients.get(0));
        Assert.assertEquals(cutlet, burger.ingredients.get(1));
    }
    @Test
    public void removeIngredientsTest() {
        Assert.assertFalse(burger.ingredients.isEmpty());
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void getOnlyBunInBurgerTest() {
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        Mockito.when(bun.getPrice()).thenReturn(500f);
        Assert.assertEquals(1000, burger.getPrice(), 0.0f);
    }
    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Red bun");
        Mockito.when(cutlet.getName()).thenReturn("cutlet");
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sausage.getName()).thenReturn("sausage");
        Mockito.when(sausage.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(hotSauce.getName()).thenReturn("hot Sauce");
        Mockito.when(hotSauce.getType()).thenReturn(IngredientType.SAUCE);
        for (int i = 0; i < burger.ingredients.size(); i++) {
            String name = burger.ingredients.get(i).getName();
            String receipt = burger.getReceipt();
            Assert.assertTrue(receipt.contains(name));
        }
        Assert.assertTrue(burger.getReceipt().contains("Red bun"));
    }
    @Mock
    Bun redBun;
    @Test
    public void checkChangeOfBunInTheBurgerTest() {
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        Mockito.when(bun.getName()).thenReturn("Black bun");
        Assert.assertTrue(burger.getReceipt().contains("Black bun"));
        burger.setBuns(redBun);
        Mockito.when(redBun.getName()).thenReturn("Red bun");
        Assert.assertFalse(burger.getReceipt().contains("Black bun"));
        Assert.assertTrue(burger.getReceipt().contains("Red bun"));
    }
}
