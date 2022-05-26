package praktikum;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    @Description("Add a bun to burger")
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @Description("Add new ingredient to the burger")
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    @Description("Remove an ingredient previously added to a burger")
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    @Description("Swap the ingredients")
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "some sauce", 100));
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

}
