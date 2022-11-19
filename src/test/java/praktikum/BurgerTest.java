package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private final String BUN_NAME = "bun";
    private final float BUN_PRICE = 300f;
    private final float INGREDIENT_PRICE = 1f;
    private final String INGREDIENT_NAME = "sour cream";
    private final String INGREDIENT_TYPE = "Sauce";

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private IngredientType ingredientType;

    @Before
    public void init() {
        burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredientType.toString()).thenReturn(INGREDIENT_TYPE);
        for(int i = 0; i<10; i++) {
            Ingredient temporaryIngredient = Mockito.mock(Ingredient.class);
            burger.ingredients.add(temporaryIngredient);
            Mockito.when(temporaryIngredient.getPrice()).thenReturn(INGREDIENT_PRICE);
            Mockito.when(temporaryIngredient.getName()).thenReturn(INGREDIENT_NAME);
            Mockito.when(temporaryIngredient.getType()).thenReturn(ingredientType);
        }
    }

    @Test
    public void setBunsTest() {
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size() - 1);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient toMove = burger.ingredients.get(0);
        burger.moveIngredient(0, 5);
        assertEquals(toMove, burger.ingredients.get(5));
        assertFalse(burger.ingredients.get(0).equals(toMove));
    }


    @Test
    public void getPriceTest() {
        assertEquals(calculatePrice(), burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", BUN_NAME));

        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", INGREDIENT_TYPE.toLowerCase(),
                    INGREDIENT_NAME));
        }

        receipt.append(String.format("(==== %s ====)%n", BUN_NAME));
        receipt.append(String.format("%nPrice: %f%n", calculatePrice()));
        assertEquals(receipt.toString(), burger.getReceipt());
    }

    private float calculatePrice() {
        return BUN_PRICE * 2 + burger.ingredients.size() * INGREDIENT_PRICE;
    }
}
