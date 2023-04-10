import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;
    @Before
    public void setUp() {
        Mockito.when(bun.getPrice()).thenReturn(12345.67F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getName()).thenReturn("Test ingredient name");
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize > 0;

        assertTrue("The size of the ingredients list must be greater than 0", actual);
    }
    @Test
    public void removeIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals(24691.34F, burger.getPrice(), 0);
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0, 1);

        assertEquals("Test ingredient name", burger.ingredients.get(1).getName());
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(24891.34F, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptTest() {
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n",
                        burger.ingredients.get(0).getType().toString().toLowerCase(),
                        burger.ingredients.get(0).getName()) +
                String.format("(==== %s ====)%n", "black bun") +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actual = burger.getReceipt();
        assertEquals(expectedReceipt, actual);
    }
}
