package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;



    @Test
    public void testAddIngredientsAndGetPrice() {

        when(bun.getPrice()).thenReturn(1F);
        when(ingredient.getPrice()).thenReturn(2F);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertThat(burger.getPrice()).isCloseTo(4.0F, offset(0.001F));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        assertThat(burger.ingredients).isEmpty();
    }

    @Test
    public void testMoveIngredient() {
        Ingredient first = new Ingredient(SAUCE, "first", 30);
        Ingredient second = new Ingredient(FILLING, "second", 50);
        Ingredient third = new Ingredient(FILLING, "third", 20);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(first);
        burger.addIngredient(second);
        burger.addIngredient(third);
        burger.moveIngredient(2, 1);

        assertThat(burger.ingredients).isEqualTo(List.of(first, third, second));
    }
}