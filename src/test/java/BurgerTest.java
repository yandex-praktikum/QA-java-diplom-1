import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
   @Mock
    Bun bun;

   @Mock
    Ingredient ingredient;


    public List<Ingredient> ingredients = new ArrayList<>();


   @Test
   public void checkAddingIngredient(){
       Burger burger = new Burger();
       burger.addIngredient(ingredient);
       assertEquals(1, burger.ingredients.size());

    }

    @Test

    public void checkRemovingIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int before = burger.ingredients.size();
        burger.removeIngredient(0);
        int after = burger.ingredients.size();
        assertEquals(before-1, after);
    }


//    @Test
//    public void checkGetPrice(){
//        Burger burger = new Burger();
//        Mockito.when(bun.getPrice()).thenReturn(1.1F);
//        Mockito.when(ingredients.getPrice()).thenReturn(2.0F);
//        assertEquals(24,burger.getPrice(),0);
//
//    }


}
