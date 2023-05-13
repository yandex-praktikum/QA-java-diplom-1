import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BurgerTest {
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSetBunsMakesBunNotNull() {
        burger.setBuns(new Bun("Булачка с корицей", 2));
        assertNotNull(burger.bun);
    }

    @Test
    public void checkAddIngredientMakesSizeEqualsOne() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "barbeque", 25));
        assertEquals("Размер должен равняться одному", burger.ingredients.size(), 1);
    }

    @Test
    public void checkRemoveIngredientMakesSizeEqualsZero() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "barbeque", 25));
        burger.removeIngredient(0);
        assertEquals("Размер должен равняться нулю", burger.ingredients.size(), 0);
    }

    @Test
    public void checkMoveIngredientCorrectPosition() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "barbeque", 25));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "pork", 45));
        burger.moveIngredient(1, 0);
        assertEquals("Первый ингредиентом должен быть pork", burger.ingredients.get(0).getName(), "pork");
    }
}
