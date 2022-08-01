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
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient0;

    @Mock
    Ingredient ingredient1;

    Burger burger = new Burger();

    @Test
    public void setBunInBurger() {
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void checkAddIngredientInBurger() {
        int ingredientsCountExpected = 1;
        burger.addIngredient(ingredient);

        Assert.assertEquals(ingredientsCountExpected, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        List<Ingredient> expected = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void checkMoveIngredientsInBurger() {
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);
        assertEquals(burger.ingredients, List.of(ingredient1, ingredient0));
    }

    @Test
    public void priceShouldBeGreaterThanZero() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getPrice()).thenReturn(150.55f);
        Mockito.when(ingredient.getPrice()).thenReturn(50f);
        Mockito.when(ingredient0.getPrice()).thenReturn(99.85f);
        Mockito.when(ingredient1.getPrice()).thenReturn(43.25f);

        assertEquals(burger.getPrice(), 494.2f, 0.0);
    }

    @Test
    public void receiptShouldNotBeEmpty() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(bun.getName()).thenReturn("BunName");

        Mockito.when(ingredient.getName()).thenReturn("IngredientName");
        Mockito.when((ingredient.getType())).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        String expectedString = "BunName: BunName\n" +
                "sauce: IngredientName\n" +
                "BunName: BunName\n" +
                "Price: 220,000000";

        assertEquals(burger.getReceipt(), expectedString);
    }
}