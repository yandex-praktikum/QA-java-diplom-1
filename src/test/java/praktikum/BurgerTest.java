package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredientInBurger() {
        burger.addIngredient(ingredient);

        int ingredientsCountExpected = 1;

        Assert.assertEquals(
                "Должно быть 3 ингредиента в бургере.",
                ingredientsCountExpected,
                burger.ingredients.size()
        );
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        List<Ingredient> expected = new ArrayList<>();

        Assert.assertEquals(
                "Не должно быть ингредиентов в бургере, после удаления.",
                expected,
                burger.ingredients
        );
    }

    @Test
    public void shouldMoveIngredientInBurger() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);

        Assert.assertNotNull(
                "Ингредиента он должен поменять позицию.",
                burger.ingredients.get(1)
        );
    }

    @Test
    public void priceShouldBeGreaterThanZero() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(1000));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(1000));

        Assert.assertTrue(
                "Цена бургера должна быть больше нуля.",
                burger.getPrice() > 0.0f
        );
    }

    @Test
    public void receiptShouldNotBeEmpty() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("BunName");

        Mockito.when(ingredient.getName()).thenReturn("IngredientName");
        Mockito.when((ingredient.getType())).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        Assert.assertFalse(
                "Рецепт бургера не должен быть пустым.",
                burger.getReceipt().isEmpty()
        );
    }
}