package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private final String bunName;
    private final String type;
    private final String ingredientName;
    private final float ingredientPrice;
    private final String expectedReceipt;

    public BurgerParametrizedTest(String bunName, String type, String ingredientName, float ingredientPrice, String expectedReceipt) {
        this.bunName = bunName;
        this.type = type;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expectedReceipt = expectedReceipt;
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters()
    public static Object[][] parameters() {
        return new Object[][]{
                {"круглая", "SAUCE", "кетчуп", 30, "(==== круглая ====)\n= sauce кетчуп =\n(==== круглая ====)\n\nPrice: 30.000000\n"},
                {"квадратная", "FILLING", "котлета", 60, "(==== квадратная ====)\n= filling котлета =\n(==== квадратная ====)\n\nPrice: 60.000000\n"}
        };
    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn(bunName);
        when(ingredient.getType()).thenReturn(IngredientType.valueOf(type));
        when(ingredient.getName()).thenReturn(ingredientName);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertThat(burger.getReceipt()).isEqualTo(expectedReceipt);

    }


}
