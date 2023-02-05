import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger;

    @Before
    public void before() {
        burger = new Burger();
    }

    @Test
    public void ingredientsCanBeAdded() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize > 0;
        assertTrue("Expected ingredient list size more than 0", actual);
    }

    @Test

    public void ingredientCanBeRemoved() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        int expectedResult = 0;
        burger.removeIngredient(0);
        assertEquals(expectedResult, burger.ingredients.size());
    }
    @Test
    public void bunsCanBeSet() {
        List<Bun> buns = new ArrayList<>();
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        buns.add(bun);
        int bunsSize = buns.size();
        boolean actual = bunsSize > 0;
        assertTrue("Expected true and  buns size more than 0", actual);
    }
    @Test
    public void getPriceReturnedCorrectPrice() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        float expectedResult = 200;
        assertEquals("The price incorrect", expectedResult, burger.getPrice(), 0);

    }
    @Test

    public void ingredientCanBeMoved() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("Sauce");
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0, 1);
        String expectedResult = "Sauce";
        assertEquals(expectedResult, burger.ingredients.get(1).getName());
    }

    @Test
    public void checkGetValidReceipt() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(),
                burger.ingredients.get(0).getName()));
        expected.append(String.format("(==== %s ====)%n", "black bun"));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expectedReceipt = expected.toString();
        String actual = burger.getReceipt();
        assertEquals(expectedReceipt, actual);
    }
}
