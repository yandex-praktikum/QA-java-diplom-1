import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
   @Mock
    Bun bun;

   @Mock
    Ingredient ingredient;

    @Test
    public void checkInitializationBun(){
        Burger burger = new Burger();
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }
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

    @Test

    public void checkMoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(0,1);
        burger.ingredients.get(0).equals(new Ingredient(IngredientType.FILLING, "sausage", 300));

    }


    @Test
    public void checkGetPrice(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(1.1F);
        Mockito.when(ingredient.getPrice()).thenReturn(2.0F);
        assertEquals(4.2,burger.getPrice(),0.1);

    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        Mockito.when(bun.getName()).thenReturn("white bun");
        assertEquals("(==== white bun ====)\n= filling sausage =\n(==== white bun ====)\n\nPrice: 300,000000\n",burger.getReceipt());
    }

}
