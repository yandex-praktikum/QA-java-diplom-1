package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(bun.getPrice()).thenReturn(2f);
        burger.setBuns(bun);
        String resultName = burger.bun.getName();
        float resultPrice = burger.bun.getPrice();
        String expectedName = "Bun";
        float expectedPrice = 2f;
        Assert.assertEquals(expectedName, resultName);
        Assert.assertEquals(expectedPrice, resultPrice, 0.01f);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int result = burger.ingredients.size();
        int expected = 1;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int result = burger.ingredients.size();
        int expected = 0;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(null);
        burger.moveIngredient(0, 1);
        Assert.assertNotNull(burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float result = burger.getPrice();
        float expected = 3f;
        Assert.assertEquals(expected, result, 0.01f);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Cheese");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String result = burger.getReceipt();
        String expected = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                "Bun", IngredientType.SAUCE.toString().toLowerCase(), "Cheese", "Bun", 3f);
        Assert.assertEquals(expected, result);
    }
}
