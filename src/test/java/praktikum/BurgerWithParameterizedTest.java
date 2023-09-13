package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BurgerWithParameterizedTest {
    Burger burger = new Burger();
    private final int index;
    private final int newIndex;

    public BurgerWithParameterizedTest(int index, int newIndex) {
        this.index = index;
        this.newIndex = newIndex;
    }

    @Before
    public void createTestBurger(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredientTwo = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientTwo);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientTwo);
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {3, 0},
                {2, 1},
                {1, 3},
                {0, 2},
                {2, 2},
        };
    }
    @Test
    public void moveIngredientTest() {
        Ingredient expexted = burger.ingredients.get(index);
        burger.moveIngredient(index,newIndex);
        Ingredient actual = burger.ingredients.get(newIndex);
        assert(actual.equals(expexted));

    }
}
