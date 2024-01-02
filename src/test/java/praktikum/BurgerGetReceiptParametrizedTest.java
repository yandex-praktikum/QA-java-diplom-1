package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParametrizedTest {

    private final Bun bun;
    private final Ingredient[] ingredients;
    private final String expectedReceipt;

    public BurgerGetReceiptParametrizedTest(Bun bun, Ingredient[] ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Bun bun1 = mock(Bun.class);
        when(bun1.getName()).thenReturn("white bun");
        when(bun1.getPrice()).thenReturn(200f);

        Ingredient ingredient1_1 = mock(Ingredient.class);
        when(ingredient1_1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1_1.getName()).thenReturn("cutlet");
        when(ingredient1_1.getPrice()).thenReturn(100f);

        Ingredient ingredient1_2 = mock(Ingredient.class);
        when(ingredient1_2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1_2.getName()).thenReturn("hot sauce");
        when(ingredient1_2.getPrice()).thenReturn(50f);

        String expectedReceipt1 = "(==== white bun ====)" + System.lineSeparator() +
                "= filling cutlet =" + System.lineSeparator() +
                "= sauce hot sauce =" + System.lineSeparator() +
                "(==== white bun ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 550.000000" + System.lineSeparator();

        Bun bun2 = mock(Bun.class);
        when(bun2.getName()).thenReturn("black bun");
        when(bun2.getPrice()).thenReturn(150f);

        Ingredient ingredient2_1 = mock(Ingredient.class);
        when(ingredient2_1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2_1.getName()).thenReturn("dinosaur");
        when(ingredient2_1.getPrice()).thenReturn(120f);

        Ingredient ingredient2_2 = mock(Ingredient.class);
        when(ingredient2_2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2_2.getName()).thenReturn("chili sauce");
        when(ingredient2_2.getPrice()).thenReturn(80f);

        String expectedReceipt2 = "(==== black bun ====)" + System.lineSeparator() +
                "= filling dinosaur =" + System.lineSeparator() +
                "= sauce chili sauce =" + System.lineSeparator() +
                "(==== black bun ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 500.000000" + System.lineSeparator();

        return Arrays.asList(new Object[][]{
                {bun1, new Ingredient[]{ingredient1_1, ingredient1_2}, expectedReceipt1},
                {bun2, new Ingredient[]{ingredient2_1, ingredient2_2}, expectedReceipt2}
        });
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Arrays.asList(ingredients).forEach(burger::addIngredient);

        assertEquals(expectedReceipt, burger.getReceipt().replace(",", "."));
    }
}
