import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientsTest {

    private final int index;
    private final int newIndex;
    private final int indexForFirstIngredient;
    private final int indexForSecondIngredient;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    public BurgerMoveIngredientsTest(int index, int newIndex, int indexForFirstIngredient, int placeForSecondIngredient1 ) {
        this.index = index;
        this.newIndex = newIndex;
        this.indexForFirstIngredient = indexForFirstIngredient;
        this.indexForSecondIngredient = placeForSecondIngredient1;
    }

    @Parameterized.Parameters
    public static Object[][] testIndexes(){
        return new Object[][]{
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,1}
        };
    }
    @Before
    public void setUp(){

    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(index,newIndex);

        assertEquals(firstIngredient, burger.ingredients.get(indexForFirstIngredient));
        assertEquals(secondIngredient, burger.ingredients.get(indexForSecondIngredient));
    }
}
