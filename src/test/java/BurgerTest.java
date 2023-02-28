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
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        Assert.assertTrue(burger.ingredients.size() > 0);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(firstIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(1));
        Assert.assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(50.5f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(80f);
        Assert.assertEquals(330.5f, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        Burger burgerSpy = Mockito.spy(burger);
        String bunName = "Булка";
        String fIngName = "Шницель";
        String sIngName = "Соус";
        IngredientType ingredientType = Mockito.mock(IngredientType.class);
        String ingTypeStr = "особый";

        burgerSpy.bun = bun;
        burgerSpy.ingredients.add(firstIngredient);
        burgerSpy.ingredients.add(secondIngredient);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(firstIngredient.getName()).thenReturn(fIngName);
        Mockito.when(firstIngredient.getType()).thenReturn(ingredientType);
        Mockito.when(secondIngredient.getName()).thenReturn(sIngName);
        Mockito.when(secondIngredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredientType.toString()).thenReturn(ingTypeStr);

        String expected = String.format("(==== %s ====)%n" +
                "= %s %s =%n" +
                "= %s %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: 0,000000%n", bunName, ingTypeStr, fIngName, ingTypeStr, sIngName, bunName);
        Assert.assertEquals(expected, burgerSpy.getReceipt());
        Mockito.verify(burgerSpy, Mockito.times(1)).getPrice();
    }
}
