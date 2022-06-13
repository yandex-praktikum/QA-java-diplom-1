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

import java.util.Objects;

public class BurgerTest {

    @Test
    public void setBunsDeterminesBun(){
        Bun bun = new Bun("black bun", 100);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientToListOfIngredients(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientFromListOfIngredients(){
            Burger burger = new Burger();
            Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
            burger.addIngredient(ingredient);
            burger.removeIngredient(0);
            int expectedResult = 0;
            int actualResult = burger.ingredients.size();
            Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveIngredientChangesPositionOfIngredientInIngredientList(){
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void returnPriceBurgerWithBlackBunHotSauceAndCutletReturnCorrectPrice(){
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedResult = 400;
        float actualResult = burger.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptBurgerWithBlackBunHotSauceAndCutletReturnCorrectReceipt(){
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedResult = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling cutlet =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 400,000000"+
                "\n";
        String actualResult = burger.getReceipt();
        Assert.assertEquals(expectedResult.replaceAll("\n", "").replaceAll("\r", ""), actualResult.replaceAll("\n", "").replaceAll("\r", ""));
    }
}
