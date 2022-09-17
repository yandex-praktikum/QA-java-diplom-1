import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    float bunStub;
    float ingredientStub;
    float expectedStub;
    public BurgerParameterizedTest(float bunStub, float ingredientStub, float expectedStub) {
        this.bunStub = bunStub;
        this.ingredientStub = ingredientStub;
        this.expectedStub = expectedStub;
    }
    @Spy
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[] getSumData() {
        return new Object[][] {
                { 100f, 200f, 800f},
                { 200f, 200f, 1000f},
        };
    }

    @Test
    @DisplayName("Get price test")
    @Description("Тестирование метода, возвращающего общую цену")
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunStub);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientStub);
        float expected = expectedStub;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.1);
    }
}
