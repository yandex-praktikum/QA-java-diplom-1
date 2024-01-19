package praktikum;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;


@RunWith(Parameterized.class)

public class BurgerTest {

    private final int index;
    private final int newIndex;

    public BurgerTest(int index, int newIndex) {
        this.index = index;
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {1, 1}
        };
    }


    @Before
    public void setMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Burger ingredients;


    @Test
    public void getPrice() {

        when(bun.getPrice())
                .thenReturn(988.0f);
        when(ingredient.getPrice())
                .thenReturn(1337.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(3313.0f, equalTo(burger.getPrice()));
    }

    @Test
    public void getReceipt() {

        Mockito.when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(988.0f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getName()).thenReturn("cutlet");
        when(ingredient.getPrice()).thenReturn(1337.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(("(==== black bun ====)\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 3313.000000\n"), equalTo(burger.getReceipt()));
    }

}

   // @Test
    //public void removeIngredientTest (){

        //Burger burger = new Burger();
        //burger.removeIngredient(int index, int newIndex);

        //Assert.assertEquals();
    //}

