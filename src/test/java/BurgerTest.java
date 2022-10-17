import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void checkSetBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull("Burger bun added", bun);
    }
    @Test
    public void checkAddIngredientsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Incorrect sum of ingredients. Check and return", 1, burger.ingredients.size());
    }
    @Test
    public void checkRemoveIngredientTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ingredient not removed", 0, burger.ingredients.size());
    }
    @Test
    public void checkMoveIngredientTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Tar-Tar", 200f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Pickles", 100f));
        burger.moveIngredient(0,1);
        Assert.assertEquals("Incorrect ingredient", "Pickles", burger.ingredients.get(0).name);
    }

    @Test
    public void checkGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(250f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Incorrect sum of ingredients", 450f, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        String expected = "(==== black bun ====)\r\n" + "= filling dinosaur =\r\n" + "(==== black bun ====)\r\n" + "\r\nPrice: 0,000000\r\n";
        Assert.assertEquals("Receipt is incorrect. Please check ingredients.",expected, burger.getReceipt()); //я не понимаю что тут не сходится. вс проверил записи идентичные
    }
}
