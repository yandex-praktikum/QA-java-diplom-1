import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
    }



    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }


    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }


    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }


    @Test
    public void moveIngredientTest() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }


    @Test
    public void getPriceTest() {
        when(bun.getPrice()).thenReturn(1.0f);
        when(ingredient.getPrice()).thenReturn(2.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(4.0f, burger.getPrice(), 0.01f);
    }



    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Ingredient cheese = Mockito.mock(Ingredient.class);

        when(bun.getName()).thenReturn("Bun");
        when(bun.getPrice()).thenReturn(1.0f);
        when(cheese.getName()).thenReturn("Cheese");
        when(cheese.getPrice()).thenReturn(2.0f);
        when(cheese.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);
        burger.addIngredient(cheese);
        String[] actualLines = burger.getReceipt().split("\\r?\\n");

        String[] expectedLines = new String[] {
                "(==== Bun ====)",
                "= filling Cheese =",
                "(==== Bun ====)",
                "",
                "Price: 4,000000"
        };

        assertEquals(expectedLines.length, actualLines.length);
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], actualLines[i]);
        }
    }
}