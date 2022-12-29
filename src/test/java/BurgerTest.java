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
public class BurgerTest {

    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient_0;

    @Mock
    Ingredient ingredient_1;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient_0);
        Assert.assertEquals(ingredient_0, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient_0);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient_0);
        burger.addIngredient(ingredient_1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient_1, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient_0);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient_0.getPrice()).thenReturn(1f);
        Assert.assertEquals(5f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient_0);
        Mockito.when(bun.getName()).thenReturn("Юнит-тестовая булка");
        Mockito.when(ingredient_0.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient_0.getName()).thenReturn("Юнит-тестовый соус");
        String expectedResult = "(==== Юнит-тестовая булка ====)= sauce Юнит-тестовый соус =(==== Юнит-тестовая булка ====)Price: 0,000000";
        Assert.assertEquals(expectedResult, burger.getReceipt().replaceAll("\r\n?|\n", ""));
    }

}
