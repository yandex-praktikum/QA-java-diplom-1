import org.junit.Assert;
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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    List<Ingredient> ingredients;
    @Mock
    private Ingredient ingredient;


    @Test
    public void addIngredientTest() {
        Burger burger = new Burger(bun,ingredients);
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients).add(ingredient);
    }

   @Test
   public void removeIngredientTest() {
       Burger burger = new Burger(bun,ingredients);
       burger.removeIngredient(1);
       Mockito.verify(ingredients).remove(1);
    }

    @Test
   public void moveIngredientTest () {
      Burger burger = new Burger(bun,ingredients);
      burger.moveIngredient(1, 1);
      Mockito.verify(ingredients).add(1, ingredients.remove(1));
    }


    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("black bun",100));
        Assert.assertEquals(200,
                burger.getPrice(),0);
}
    @Test
    public void getReceiptTest() {
        Database database=new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        List<Bun> buns = database.availableBuns();
        Burger burger = new Burger(bun,ingredients);
        Mockito.when(bun.getName()).thenReturn(buns.get(2).getName());
        burger.getReceipt();
        Mockito.verify(bun,Mockito.times(2)).getName();
        System.out.println(burger.getReceipt().toString());

    }}
