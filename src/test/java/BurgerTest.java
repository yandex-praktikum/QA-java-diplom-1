import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;


public class BurgerTest {


    Database database = new Database();
    List<Bun> buns = database.availableBuns();
    Burger burger = new Burger();
    List<Ingredient> ingredients = database.availableIngredients();





    @Test
    public void checkAddIngredientsInBurger(){
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(2));

        Assert.assertEquals(burger.getPrice(),500,0);
    }

    @Test
    public void checkRemoveIngredientsInBurger(){
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(3));
        burger.removeIngredient(0);

        Assert.assertEquals(burger.getPrice(), 200,0);
    }

    @Test
    public void checkRemoveMissIngredientsInBurger(){
        Exception exception = null;

       try {
           burger.setBuns(buns.get(0));
           burger.removeIngredient(0);
       }catch (Exception ex) {
           exception =ex;
       }
       Assert.assertNotNull("Ошибка при удалении несущ. ингредиента",exception);
    }

    @Test
    public void checkMoveIngredientsInBurger(){
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(3));

        burger.moveIngredient(0,1);

        Assert.assertEquals(burger.getReceipt(),"(==== white bun ====)\n" +
                "= sauce sour cream =\n" +
                "= filling dinosaur =\n" +
                "= filling cutlet =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 900,000000\n");
    }

}
