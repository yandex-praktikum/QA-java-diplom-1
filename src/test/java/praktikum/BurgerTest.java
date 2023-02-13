package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn((float) 100);
        Mockito.when(bun.getPrice()).thenReturn((float) 300);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(700, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== black bun ====)\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 700,000000\n";
        assertEquals(expectedReceipt, actualReceipt);
    }

    @After
    public void clear() {
        burger.ingredients.clear();
    }
}