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

@RunWith(Parameterized.class)
public class BurgerParametrizedPriceTest {
    private final List<Ingredient> ingredientsData;
    private static Ingredient ingredient1 = Mockito.mock(Ingredient.class);
    private static Ingredient ingredient2 = Mockito.mock(Ingredient.class);

    public BurgerParametrizedPriceTest(List<Ingredient> ingredientsData){
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
    public void checkGetPriceBurgerMethodCallsTest(){
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        burger.ingredients = ingredientsData;

        burger.getPrice();

        Mockito.verify(bun,Mockito.times(1)).getPrice();
        Mockito.verify(ingredient1, Mockito.times(burger.ingredients.size())).getPrice();
    }
}
