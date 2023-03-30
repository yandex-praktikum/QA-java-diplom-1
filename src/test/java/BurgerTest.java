import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    List<Bun> bun;

    @Mock
    Ingredient ingredient;

    @Mock
    List<Ingredient> ingredients;

    @Test
    public void burgerAddIngredientAddsIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        Mockito.verify(ingredients, Mockito.times(1)).add(ingredient);
    }
}
