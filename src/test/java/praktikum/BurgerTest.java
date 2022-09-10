package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    //@Mock
    Bun bun;
    List<Ingredient> ingredients;

    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(burger.getBuns(),bun);
    }

    //Это все неправильно, и не представляю как сделать
    //@Mock
    Ingredient ingredient;

    @Test
    public void checkAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(ingredients.get(0), ingredient);
    }
}
