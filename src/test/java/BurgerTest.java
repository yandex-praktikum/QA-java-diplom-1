import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
    burger.addIngredient(ingredient);

    Ingredient expectedIngredient = burger.ingredients.get(0);
    int expectedSize = 1;
    int actualSize = burger.ingredients.size();
    assertEquals(expectedIngredient, ingredient);
    assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int expectedSize = 0;
        int actualSize = burger.ingredients.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void moveIngredientIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);

        int expectedIndex = 0;
        int actualIndex = burger.ingredients.indexOf(ingredient2);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient2.getPrice()).thenReturn(150F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        float expectedPrice = 450F;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0F);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 100.000000\n";
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }
}

