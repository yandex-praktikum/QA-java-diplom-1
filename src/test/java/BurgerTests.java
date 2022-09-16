import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTests {
@Mock
Ingredient ingredient = new Ingredient(IngredientType.FILLING, "chicken", 200);


    @Test
    public void ingredientAddSuccessfullyTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);

    }
}
