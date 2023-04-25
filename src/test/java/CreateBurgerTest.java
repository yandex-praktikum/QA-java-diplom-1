import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CreateBurgerTest {
    int index;
    int newIndex;

    @Mock
    Bun bun;
    @Mock
    List<Ingredient> ingredients;
    @Mock
    Ingredient ingredient;

    @Test
    public  void addIngredientTest(){
        Burger burger = new Burger (bun,ingredients);
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients,Mockito.times(1)).add(ingredient);

    }
    @Test
    public  void removeIngredientTest(){
        Burger burger = new Burger (bun,ingredients);
        burger.removeIngredient (index);
        Mockito.verify(ingredients,Mockito.times(1)).remove(index);
    }
    @Test
    public  void moveIngredientTest(){
        Burger burger = new Burger (bun,ingredients);
        burger.moveIngredient (index,newIndex);
        Mockito.verify(ingredients,Mockito.times(1)).add(newIndex, ingredients.remove(index));
    }
    @Test
    public  void getBurgerPriceTest(){
        Database database=new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients=database.availableIngredients();
        Burger burger = new Burger (bun,ingredients);
        Mockito.when(bun.getPrice()).thenReturn(buns.get(0).getPrice());
        assertEquals (1400, burger.getPrice(),0);
        System.out.println("Burger price is: " + burger.getPrice());
    }
    @Test
    public  void getBurgerReceiptTest(){
        Database database=new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients=database.availableIngredients();
        Burger burger = new Burger (bun,ingredients);
        Mockito.when(bun.getName()).thenReturn(buns.get(2).getName());
        burger.getReceipt();
        Mockito.verify(bun,Mockito.times(2)).getName();
        assertEquals ("red bun", bun.getName());
        System.out.println(burger.getReceipt());
    }
}
