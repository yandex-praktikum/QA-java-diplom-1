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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientAdditional;
    @Mock
    Ingredient movableIngredient;

    @Before
    public void setUpBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        int expectedIngredientsCount = 3;

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Assert.assertEquals(expectedIngredientsCount, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        int expectedIngredientsCount = 1;

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals(expectedIngredientsCount, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(movableIngredient);
        List<Ingredient> newList = new ArrayList<>(Arrays.asList(movableIngredient, ingredient));

        burger.moveIngredient(0, 1);
        Assert.assertEquals(newList, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(150F);

        Assert.assertEquals(350, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientAdditional);

        Mockito.when(bun.getName()).thenReturn("Harrys");
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(ingredient.getName()).thenReturn("1000_островов");
        Mockito.when(ingredient.getPrice()).thenReturn(30f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(ingredientAdditional.getName()).thenReturn("Лук");
        Mockito.when(ingredientAdditional.getPrice()).thenReturn(20f);
        Mockito.when(ingredientAdditional.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("= %s %s =%n", ingredientAdditional.getType().toString().toLowerCase(), ingredientAdditional.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}