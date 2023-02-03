import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    Burger burger = new Burger();
    @Test
    public void setBunTest(){
        Bun bun = new Bun("name",100);
        burger.setBuns(bun);
        Assert.assertEquals("name", burger.bun.getName());
    }
    @Test
    public void addIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 100);
        burger.addIngredient(ingredient);
        Assert.assertEquals(true, burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 100);
        burger.ingredients.add(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        Assert.assertEquals(false, burger.ingredients.contains(ingredient));
    }
    @Test
    public void moveIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 100);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "name1", 200);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);
        int index = burger.ingredients.indexOf(ingredient);
        int nextIndex = burger.ingredients.indexOf(ingredient1);
        burger.moveIngredient(index, nextIndex);
    }
    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(2F);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        Assert.assertEquals(5.0, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptIsNotEmptyTest(){
        Mockito.when(bun.getName()).thenReturn("bun");
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "ingredient", 1);
        burger.ingredients.add(ingredient);
        Assert.assertEquals(false, burger.getReceipt().isEmpty());
    }
}
