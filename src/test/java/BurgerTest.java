import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Ingredient ingredient;
    Burger burger;
    List<Ingredient> ingredients = new ArrayList<>();
    @Mock
    Bun bun;
//    Ingredient ingredient;

    @Test
    public void checkAddIngredient() {
        burger = new Burger();
        ingredient = new Ingredient(FILLING, "cutlet", 100f);
        burger.addIngredient(ingredient);
        System.out.println(ingredients);
//        assertEquals(1, ingredients.size());
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(300f, burger.getPrice(), 0.001);

    }
}
