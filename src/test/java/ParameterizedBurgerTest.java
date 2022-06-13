import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class ParameterizedBurgerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;

    private final IngredientType ingredientType;

    public ParameterizedBurgerTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.stream(IngredientType.values())
                .map(value -> new Object[]{value})
                .collect(Collectors.toSet());
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String bunName = "Булочка";
        String ingredientName = "Сыр";
        float expectedPrice = 200f;
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(100f);

        StringBuilder tmpReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));
        tmpReceipt.append(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("%nPrice: %f%n", expectedPrice));
        String expectedReceipt = tmpReceipt.toString();

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("Квитанция некорректная", expectedReceipt, actualReceipt);

    }
}
