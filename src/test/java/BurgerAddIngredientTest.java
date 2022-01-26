import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerAddIngredientTest {
    Burger burger;
    Ingredient ingredient1,ingredient2;

List<Ingredient> expected = new ArrayList<>();
    @Before
    public void before(){
        burger = new Burger();
        ingredient1 = new Ingredient(IngredientType.SAUCE,"abcd",7f);
        ingredient1 = new Ingredient(IngredientType.FILLING,"dcba",7.1f);
    }
    @Test
    public void testThatOneIngredientAddedToIngredientsList(){
        burger.addIngredient(ingredient1);
        assertEquals("Добавлен ли ингредиент",ingredient1,burger.ingredients.get(0));
    }
}
