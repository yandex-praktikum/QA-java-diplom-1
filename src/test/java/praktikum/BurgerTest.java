package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final static float DELTA = (float)0.00000001;

    @Mock
    private Burger mockBurger;

    @Test
    public void setBuns() {
        Bun bun = new Bun("bun", (float)1.0);
        mockBurger.setBuns(bun);
        Mockito.verify(mockBurger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "teriyaki", (float)2.0);
        mockBurger.addIngredient((ingredient));
        Mockito.verify(mockBurger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredient() {
        int ingredientIndex = 2;
        mockBurger.removeIngredient(ingredientIndex);
        Mockito.verify(mockBurger, Mockito.times(1)).removeIngredient(ingredientIndex);
    }

    @Test
    public void moveIngredient() {
        int oldIndex = 2;
        int newIndex = 0;
        mockBurger.moveIngredient(oldIndex, newIndex);
        Mockito.verify(mockBurger, Mockito.times(1)).moveIngredient(oldIndex, newIndex);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", (float)5.0 ));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili", (float)2.0));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "meat", (float)8.0));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cheese", (float)3.0));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "salad", (float)2.0));
        assertEquals((float)25.0, burger.getPrice(), DELTA);
    }
}