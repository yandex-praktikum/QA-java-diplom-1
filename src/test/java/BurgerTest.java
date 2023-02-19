
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;


import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Before
    public void setUp() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void getPriceTest() {
        when(bun.getPrice()).thenReturn(2F);
        when(ingredient.getPrice()).thenReturn(2F);
        float expected = 6F;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("булочка");
        when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        when(ingredient.getName()).thenReturn("острый");
        String receipt = burger.getReceipt();
        String bun = "(==== булочка ====)";
        String ingredient = "= sauce острый =";
        assertThat(receipt,
                allOf(containsString(ingredient),
                        containsString(bun)));
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        int actual = burger.ingredients.size();
        System.out.println(actual);
        assertEquals(3, actual, 0);
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        assertEquals(0, actual, 0);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.moveIngredient(0, 2);
        int actual = burger.ingredients.size();
        assertEquals(3, actual, 0);
    }

}
