package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    Faker faker = new Faker();
    float expectedPrice;
    float bunPrice;
    float ingredientPrice;
    Burger burger = new Burger();


    public BurgerParametrizedTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Parameterized.Parameters
    public static Object[][] sexTest() {
        return new Object[][]{
                {3.14f,3.14f,9.14f},
                {0f,0f,0f},
        };
    }

    @Test
    public void getPrice() throws Exception {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn((ingredientPrice));
        assertEquals(expectedPrice,burger.getPrice(),1);

    }


}
