package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    List<Ingredient> ingredients = new ArrayList<>();
    IngredientType sauceType = IngredientType.SAUCE;
    IngredientType fillingType = IngredientType.FILLING;
  //  Burger burger =  new Burger();


    /*  @Test
    public void checkSetBun(){
        burger.setBuns(bun);
    } */

    public void addIngredient(Burger burger){
        Ingredient hotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 200);
        burger.addIngredient(hotSauce);
        Ingredient chickenFillet = new Ingredient(IngredientType.FILLING, "chicken fillet", 100);
        burger.addIngredient(chickenFillet);
    }
    @Test
    public void testAddIngredient(){
        Burger burger =  new Burger();
        addIngredient(burger);
        IngredientType sauceType = IngredientType.SAUCE;
        IngredientType fillingType = IngredientType.FILLING;
        assertEquals(sauceType, burger.ingredients.get(0).type);
        assertEquals("hot sauce", burger.ingredients.get(0).name);
        assertEquals(200,burger.ingredients.get(0).price, 0.0);
        assertEquals(fillingType, burger.ingredients.get(1).type);
        assertEquals("chicken fillet", burger.ingredients.get(1).name);
        assertEquals(100, burger.ingredients.get(1).price, 0.0);
    }

    @Test
    public void testRemoveIngredient(){
        Burger burger =  new Burger();
        addIngredient(burger);
        burger.removeIngredient(0);

        assertEquals(fillingType, burger.ingredients.get(0).type);
        assertEquals("chicken fillet", burger.ingredients.get(0).name);
        assertEquals(100, burger.ingredients.get(0).price, 0.0);

        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());

    }

}
