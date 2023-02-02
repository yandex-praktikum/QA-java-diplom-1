package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce",100);
    Ingredient ingredient2= new Ingredient(IngredientType.FILLING, "sausage", 300);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1,burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce",100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn((float)300);
        assertEquals(700,burger.getPrice(),0.1);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        String actualReceipt = burger.getReceipt();
        String expectedReceipt ="(==== black bun ====)\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 100,000000\n";
        assertEquals(expectedReceipt, actualReceipt);
    }
    @After
    public void clear() {
        burger.ingredients.clear();
    }
}