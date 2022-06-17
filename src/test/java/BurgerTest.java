import org.junit.Assert;
import org.junit.Before;
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

import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Bun bun;

    @Test
    public void setBunsDeterminesBun(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientToListOfIngredients(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientFromListOfIngredients(){
            Burger burger = new Burger();
            burger.addIngredient(ingredient);
            burger.removeIngredient(0);
            int expectedResult = 0;
            int actualResult = burger.ingredients.size();
            Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void moveIngredientChangesPositionOfIngredientInIngredientList(){
        Burger burger = new Burger();
        ingredient.type = IngredientType.FILLING;
        ingredient.name = "cutlet";
        ingredient.price = 100;
        ingredientSecond.type = IngredientType.SAUCE;
        ingredientSecond.name = "how sauce";
        ingredientSecond.price = 100;
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void returnPriceBurgerWithBlackBunReturnCorrectPrice(){
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        float expectedResult = 400;
        float actualResult = burger.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptBurgerWithBlackBunHotSauceAndCutletReturnCorrectReceipt(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSecond.getName()).thenReturn("cutlet");
        Mockito.when(ingredientSecond.getPrice()).thenReturn(100F);
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
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
