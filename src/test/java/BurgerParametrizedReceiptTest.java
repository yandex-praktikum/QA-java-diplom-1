import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerParametrizedReceiptTest {
    private final List<Ingredient> ingredientsData;
    private static Ingredient ingredient1 = Mockito.mock(Ingredient.class);
    private static Ingredient ingredient2 = Mockito.mock(Ingredient.class);

    public BurgerParametrizedReceiptTest(List<Ingredient> ingredientsData){
        this.ingredientsData = ingredientsData;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {new ArrayList<>()},
                {Arrays.asList(ingredient1)},
                {Arrays.asList(ingredient1, ingredient2)},
        };
    }

    @Test
    public void checkGetReceiptBurgerMethodCallsTest(){
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        burger.ingredients = ingredientsData;
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);

        burger.getReceipt();

        Mockito.verify(bun,Mockito.times(2)).getName();
        Mockito.verify(ingredient1, Mockito.times(burger.ingredients.size())).getType();
        Mockito.verify(ingredient1, Mockito.times(burger.ingredients.size())).getName();
    }
}
