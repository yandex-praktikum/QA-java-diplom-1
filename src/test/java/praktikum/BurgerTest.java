package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
@Mock
Bun bun;

@Mock
Ingredient ingredient;

@Before
    public void setUp() {
    burger = new Burger();
}

    @Test
    public void setBuns() {
    burger.setBuns(bun);
    assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredient() {
    burger.addIngredient(ingredient);
    assertTrue(burger.ingredients.size()!=0);
    }

    @Test
    public void removeIngredient() {
    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
    burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
    burger.removeIngredient(1);
    assertEquals(1,burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        String ingredientsInitial= burger.ingredients.toString();
        burger.moveIngredient(0,1);
        String ingredientExpected=burger.ingredients.toString();
        assertNotEquals(ingredientExpected,ingredientsInitial);
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(300F,burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        bun = new Bun("Булочка с кунжутом",100F);
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        String expectedResult= burger.getReceipt();
        assertEquals(expectedResult,burger.getReceipt());

    }
}