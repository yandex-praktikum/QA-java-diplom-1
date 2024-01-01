package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSause;
    @Mock
    Ingredient ingredientFilling;
    Burger testBurger = new Burger();
    private String expectedReceipt = String.format("%s%n%s%n%s%n%s%n%n%s%n", "(==== Веганская булка ====)", "= sauce Веганский соус =", "= filling Веганская котлета =", "(==== Веганская булка ====)", "Price: 1500,000000");

    @Before
    public void setUp() {
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredientSause);
        testBurger.addIngredient(ingredientFilling);

    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Веганская булка");
        Mockito.when(ingredientSause.getName()).thenReturn("Веганский соус");
        Mockito.when(ingredientFilling.getName()).thenReturn("Веганская котлета");
        Mockito.when(ingredientSause.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(500.0F);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredientSause.getPrice()).thenReturn(400F);
        Assert.assertEquals(expectedReceipt, testBurger.getReceipt());
    }

    @Test
    public void getPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn(500.0F);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredientSause.getPrice()).thenReturn(400F);

        Assert.assertEquals(1500, testBurger.getPrice(), 0);
    }

    @Test
    public void setBunsTest() {
        testBurger.setBuns(bun);
        Assert.assertEquals(bun, testBurger.bun);
    }

    @Test
    public void addIngredientsTest() {
        int expectedBefore = 2;
        int expectedAfter = 3;
        Assert.assertEquals(expectedBefore, testBurger.ingredients.size());
        testBurger.addIngredient(ingredientSause);
        Assert.assertEquals(expectedAfter, testBurger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        int expectedBefore = 2;
        int expectedAfter = 1;
        Assert.assertEquals(expectedBefore, testBurger.ingredients.size());
        testBurger.removeIngredient(0);
        Assert.assertEquals(expectedAfter, testBurger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        String firstIngredient = String.valueOf(testBurger.ingredients.get(0));
        testBurger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient, String.valueOf(testBurger.ingredients.get(1)));

    }

}
