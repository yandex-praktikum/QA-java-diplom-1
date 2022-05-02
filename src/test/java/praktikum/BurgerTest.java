package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient second_ingredient;
    private static final String BUN_NAME = "Students Burger";
    private static final float BUN_PRICE = 100;
    private static final String INGREDIENT_NAME = "ketchup";
    private static final float INGREDIENT_PRICE = 50;
    private static final String SECOND_INGREDIENT_NAME = "sausage Every day";
    private static final float SECOND_INGREDIENT_PRICE = 100;

    @Before
    public void setUp() {
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(second_ingredient.getName()).thenReturn(SECOND_INGREDIENT_NAME);
        Mockito.when(second_ingredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);
        Mockito.when(second_ingredient.getType()).thenReturn(FILLING);
    }

    @Test
    public void shouldSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldRemoveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldMoveIngredient() {
        Burger burger = new Burger();
        int positionBefore = 2;
        int positionAfter = 4;
        for (int i = 0; i <= 5; i++) {
            burger.ingredients.add(ingredient);
        }
        Ingredient movedIngredient = burger.ingredients.get(positionBefore);
        burger.moveIngredient(positionBefore,positionAfter);
        assertEquals(movedIngredient, burger.ingredients.get(positionAfter));
    }

    @Test
    public void shouldGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(second_ingredient);
        float testBurgerPrice = bun.getPrice() * 2 + ingredient.getPrice() + second_ingredient.getPrice();
        assertEquals(testBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(second_ingredient);
        Mockito.when(burger.getPrice()).thenReturn(BUN_PRICE * 2 + INGREDIENT_PRICE + SECOND_INGREDIENT_PRICE);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()))
                .append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()))
                .append(String.format("= %s %s =%n", second_ingredient.getType().toString().toLowerCase(), second_ingredient.getName()))
                .append(String.format("(==== %s ====)%n", bun.getName()))
                .append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(receipt.toString(), burger.getReceipt());
    }
}