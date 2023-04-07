package praktikumtests;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;

    Burger burger;

    public static List<Ingredient> addIngredients(Burger burger, Ingredient... ingredients) {
        return new ArrayList<>(Arrays.asList(ingredients));

    }

    @Test
    public void getBurgerPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200);
        burger = new Burger(bun, new ArrayList<>());
        burger.ingredients = addIngredients(burger, ingredient);
        Assert.assertEquals(400f, burger.getPrice(), 0);

    }

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        burger.ingredients = addIngredients(burger, ingredient, ingredient);
        Assert.assertEquals(2, burger.ingredients.size());

    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        burger.ingredients = addIngredients(burger, ingredient, ingredient);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        Ingredient ing1 = ingredient;
        Ingredient ing2 = ingredient2;
        burger.ingredients = addIngredients(burger, ing1, ing2);
        burger.moveIngredient(burger.ingredients.indexOf(ing2), burger.ingredients.indexOf(ing1));
        Assert.assertEquals(ing1, burger.ingredients.get(1));

    }


    @Test
    public void getReceiptTest() {

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200);
        burger = new Burger(bun, new ArrayList<>());
        burger.ingredients = addIngredients(burger, ingredient);
        Assert.assertTrue(burger.getReceipt().contains("= sauce hot sauce ="));

    }

    @Test
    public void setBunsTest() {
        burger = new Burger();
        Bun b = bun;
        burger.setBuns(b);
        Assert.assertEquals(b, burger.bun);
    }




}
