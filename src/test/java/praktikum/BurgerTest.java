package praktikum;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Ingredient ingredient0;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        MatcherAssert.assertThat(burger.ingredients, IsCollectionContaining.hasItem(ingredient));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();

        List<Ingredient> ingredientsBeforeRemove = new ArrayList<>();
        ingredientsBeforeRemove.add(ingredient0);
        ingredientsBeforeRemove.add(ingredient2);
        ingredientsBeforeRemove.add(ingredient1);
        burger.ingredients = ingredientsBeforeRemove;

        List<Ingredient> ingredientsAfterRemove = new ArrayList<>();
        ingredientsAfterRemove.add(ingredient0);
        ingredientsAfterRemove.add(ingredient2);

        burger.removeIngredient(1);
        Assert.assertEquals(burger.ingredients, ingredientsAfterRemove);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();

        List<Ingredient> ingredientsBeforeMove = new ArrayList<>();
        ingredientsBeforeMove.add(ingredient0);
        ingredientsBeforeMove.add(ingredient1);
        ingredientsBeforeMove.add(ingredient2);
        burger.ingredients = ingredientsBeforeMove;

        List<Ingredient> ingredientsAfterMove = new ArrayList<>();
        ingredientsAfterMove.add(ingredient0);
        ingredientsAfterMove.add(ingredient2);
        ingredientsAfterMove.add(ingredient1);

        burger.moveIngredient(1, 2);
        Assert.assertEquals(burger.ingredients, ingredientsAfterMove);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        burger.ingredients = ingredients;

        Mockito.when(bun.getPrice()).thenReturn(130F);
        Mockito.when(ingredient.getPrice()).thenReturn(125F);
        float actualPrice = burger.getPrice();
        float expectedPrice = 635;
        Assert.assertEquals(expectedPrice, actualPrice, 0.000000000000001);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient);
        burger.ingredients = ingredients;

        Mockito.when(bun.getName()).thenReturn("bulochka");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("ogurchik");
        Mockito.when(bun.getPrice()).thenReturn(130F);
        Mockito.when(ingredient.getPrice()).thenReturn(125F);
        String expectedReceipt =
                "(==== bulochka ====)\n" +
                "= filling ogurchik =\n" +
                "= filling ogurchik =\n" +
                "(==== bulochka ====)\n\n" +
                "Price: 510.000000\n";
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}