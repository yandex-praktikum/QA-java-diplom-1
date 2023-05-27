import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.hamcrest.core.IsNull.notNullValue;

public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertThat(burger.bun, notNullValue());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertThat(burger.ingredients, notNullValue());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int result = 0;
        int size = burger.ingredients.size();
        Assert.assertEquals(result, size);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        int size = burger.ingredients.size();
        int result = 2;
        Assert.assertEquals(result, size);
    }

    @Test
    public void getPriceTest() {
        float priceResult = (float) 5;
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn((float) 2);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 1);
        float burgerPrice = burger.getPrice();
        Assert.assertEquals(priceResult, burgerPrice, 0.001);
    }
}