package praktikum;

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
    @Mock
    Ingredient ingredient2;

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
        assertEquals(
                "Должно быть " + ingredientsCountExpected + " ингредиента в бургере.",
                ingredientsCountExpected,
                burger.ingredients.size()
        );
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        List<Ingredient> expected = new ArrayList<>();

        assertEquals(
                "Не должно быть ингредиентов в бургере, после удаления.",
                expected,
                burger.ingredients
        );
    }

    @Test
    public void shouldMoveIngredientInBurger() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(
                "Ингредиент не должен менять позицию.", "ingredient2",
                burger.ingredients.get(0).toString()
        );
    }

    @Test
    public void priceShouldBeEqualSetAmount() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(1000));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(1000));
        assertTrue(
                "Цена бургера должна быть " + burger.getPrice(),
                burger.getPrice()  == 3000.0
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

        assertEquals(
                "Рецепт бургера не должен быть пустым.", false,
                burger.getReceipt().isEmpty()
        );
    }
}