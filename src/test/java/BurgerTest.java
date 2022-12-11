import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private  Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Test
    public void checkSetBuns (){
        Bun bunExpected = new Bun("black bun", 100);
        burger.setBuns(bunExpected);
        assertEquals(bunExpected, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient ingredient1 = new Ingredient(FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        assertEquals(2, burger.ingredients.size());
        assertEquals(burger.ingredients.get(0), ingredient);
        assertEquals(burger.ingredients.get(1), ingredient1);
    }

    @Test
    public void checkRemoveIngredient() {
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);
        Ingredient ingredient1 = new Ingredient(FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);
        Ingredient ingredient1 = new Ingredient(FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(1), ingredient);
    }

    @Test
    public void checkGetPrice(){
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);
        Mockito.when(bun.getPrice()).thenReturn(50f);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        assertEquals(300, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt(){
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);
        Mockito.when(bun.getName()).thenReturn("black bun");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getReceipt();
        assertEquals("black bun", bun.getName());
    }


}
