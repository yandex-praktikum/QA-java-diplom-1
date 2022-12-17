import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

 @Test
  public void checkCanSetBun() {
     Burger burger = new Burger();
     burger.setBuns(bun);
     Assert.assertEquals(burger.bun, bun);
 }

    @Test
    public void checkCanAddIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void checkCanRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expected = 0;
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void checkCanMoveIngredient(){
        Burger burger = new Burger();
     burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Mayo", 1000.00F));
     burger.moveIngredient(0, 1);
     Assert.assertEquals(ingredient, burger.ingredients.get(1));

    }

    @Test
    public void canGetPrice(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(200.00F);
        float expected= 400.00F;
        assertEquals(expected, burger.getPrice());
    }

    @Test
    public void canGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("someBun");
        Mockito.when(bun.getPrice()).thenReturn(100.00F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("chicken");
        Mockito.when(ingredient.getPrice()).thenReturn(300.00F);
        String expected = "(==== someBun ====)\n= filling chicken =\n(==== someBun ====)\n\nPrice: 500.000000\n";
        assertEquals(expected, burger.getReceipt());
    }

}
