package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {

    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient anotherIngredient;
    @Mock
    private Burger burger;
    @Mock
    private Bun bun;

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void checkRemoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void checkMoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0,1);
        Mockito.verify(burger).moveIngredient(0, 1);
    }

    @Test
    public void checkGetPriceBunsOnlyTest() {
        float randomPrice = new Random().nextFloat();
        this.bun = new Bun("", randomPrice);
        this.burger = new Burger();
        burger.setBuns(bun);
        assertEquals((randomPrice * 2), burger.getPrice(), 0);
    }

    @Test
    public void checkGetPriceBunsAndIngredientTest() {
        float randomPrice = new Random().nextFloat();
        this.bun = new Bun("", randomPrice);
        this.burger = new Burger();
        this.ingredient = new Ingredient(IngredientType.SAUCE, "", randomPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals((randomPrice * 3), burger.getPrice(), 0);
    }
}
