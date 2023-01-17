import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    public Bun bun;
    @Mock
    Database database;
    private Burger burger;

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "TestNameIngredient", 5.5f);
    @Test
    public void addIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void returnsCorrectSizeOfIngredientsAfterAdd() {
        List<Ingredient> ingredients = new ArrayList<>();
        burger = new Burger();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        Assert.assertEquals(ingredients.size() , burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        int sizeExpected = 0;
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(sizeExpected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "TestName2", 10f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "TestName", 5.5f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float priceExpected = 31f;
        Assert.assertEquals(priceExpected, burger.getPrice(),0f);
    }


    @Test
    public void getReceiptTest() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(bun.getName()).thenReturn("TestNameOfBun");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = "(====" + bun.getName() + "====)=filling" + ingredient.getName() + "=(====" + bun.getName() + "====)Price:" + String.format("%f", 25.5f);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt.replaceAll("\r\n?|\n", "").replace(" ", ""));
    }
}




