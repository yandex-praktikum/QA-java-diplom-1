import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)


public class TestRemoveIngredient {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Database database;

    Burger burger = new Burger();
    @Test
    public void removeIngredient() {

        List<Bun> bun = new ArrayList<>();
        bun.add(new Bun("black bun", 100));
        Mockito.when(database.availableBuns()).thenReturn(bun);

        List<Ingredient> ingred = new ArrayList<>();
        ingred.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingred.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));

        Mockito.when(database.availableIngredients()).thenReturn(ingred);

        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(1);

    }
}
