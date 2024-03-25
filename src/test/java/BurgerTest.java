import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.ArrayList;
import java.util.List;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    Ingredient ingredient1 = new Ingredient(SAUCE, "hot sauce", 100);
    @Mock
    Ingredient ingredient2 = new Ingredient(FILLING, "sausage", 300);

    private final List<Ingredient> ingredients = new ArrayList<>();

    @Before
    public void init() {
        burger = new Burger();
        burger.ingredients = ingredients;
    }

    @Test
    public void setBunsIsCorrectTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Expected result does not match the actual", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        ingredients.add(new Ingredient(SAUCE, "hot sauce", 100));
        Assert.assertEquals("Expected result does not match the actual", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;
        Assert.assertEquals("Expected result does not match the actual", List.of() , actual);
    }

    @Test
    public void moveIngredientTest() {
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Expected result does not match the actual", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
       Mockito.when(ingredient1.getPrice()).thenReturn(50F);
       Mockito.when(ingredient2.getPrice()).thenReturn(70F);
       Mockito.when(bun.getPrice()).thenReturn(30F);
       burger.addIngredient(ingredient1);
       burger.addIngredient(ingredient2);
       float burgerPrice = 180F;
       Assert.assertEquals("Expected result does not match the actual", burgerPrice, burger.getPrice(), 0);
    }

}
