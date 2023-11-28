package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.hamcrest.MatcherAssert;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    Burger burger;
    Ingredient ingredient;
    @Before
    public void setUP(){
        burger = new Burger();

    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.size() != 0);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());

    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        String ingredientsBefore = burger.ingredients.toString();
        burger.moveIngredient(0, 1);
        String ingredientsAfter = burger.ingredients.toString();
        assertNotEquals(ingredientsAfter, ingredientsBefore);

    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200F);
        burger.setBuns(bun);
        float expected = 400F;
        assertEquals("Wrong calculation", burger.getPrice(), expected, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        String receipt = burger.getReceipt();
        MatcherAssert.assertThat(receipt, notNullValue());
    }
}
