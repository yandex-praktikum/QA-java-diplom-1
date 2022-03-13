import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient_2;

    private final static int NEW_INDEX = 1;

    @Test
    public void shouldSetBun(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredients(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredients(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);
        int ingredientIndex = burger.ingredients.indexOf(ingredient);
        burger.moveIngredient(ingredientIndex, NEW_INDEX);
        assertEquals(NEW_INDEX, burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void shouldReturnPrice(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        float actualPrice = burger.getPrice();
        assertEquals(4,actualPrice,0);
    }

    @Test
    public void shouldReturnReceipt(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        String result = burger.getReceipt();
        String expectedResult = "(==== bun ====)\n= sauce ingredient =\n(==== bun ====)\n\nPrice: 4,000000";
        assertEquals(expectedResult, result.trim().replace("\r",""));
    }
}