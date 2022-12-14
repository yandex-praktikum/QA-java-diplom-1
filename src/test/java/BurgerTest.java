import org.junit.After;
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
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
    Burger burger = new Burger();

    @After
    public void tearDown() {
        burger.ingredients.clear();
        burger.bun = null;
    }

    @Test
    public void setBunsBunSet() {
        burger.setBuns(bun);
        Assert.assertNotNull("Bun wasn't add correctly", burger.bun);
    }

    @Test
    public void addIngredientIngredientAdded() {
        burger.addIngredient(firstIngredient);
        Assert.assertEquals("Ingredient wasn't add correctly", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientIngredientRemoved() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ingredient wasn't remove correctly", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientIngredientMoved() {
        Mockito.when(secondIngredient.getName()).thenReturn("Second ingredient");
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ingredient wasn't moved correctly", "Second ingredient", burger.ingredients.get(0).getName());
    }

    @Test
    public void getPricePriceGet() {
        float bunPrice = 200.50f;
        float firstIngredientPrice = 145.00f;
        float secondIngredientPrice = 155.00f;
        float expectedPrice = 701.00f;
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(firstIngredient.getPrice()).thenReturn(firstIngredientPrice);
        Mockito.when(secondIngredient.getPrice()).thenReturn(secondIngredientPrice);
        Assert.assertEquals("Burger price is not correct", expectedPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void checkGetReceipt() {
        String bunName = "Bun test name";
        String firstIngredientName = "First ingredient test name";
        String secondIngredientName = "Second ingredient test name";
        float burgerPrice = 200.50f;
        IngredientType ingredientType = IngredientType.SAUCE;
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName, ingredientType.toString().toLowerCase(), firstIngredientName,
                ingredientType.toString().toLowerCase(), secondIngredientName, bunName, burgerPrice);

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(firstIngredient.getName()).thenReturn(firstIngredientName);
        Mockito.when(secondIngredient.getName()).thenReturn(secondIngredientName);
        Mockito.when(firstIngredient.getType()).thenReturn(ingredientType);
        Mockito.when(secondIngredient.getType()).thenReturn(ingredientType);
        Mockito.when(burger.getPrice()).thenReturn(burgerPrice);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

}
