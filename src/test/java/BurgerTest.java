import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private List<Ingredient> mockIngredients;
    @Mock
    private Ingredient ingredient;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.ingredients = mockIngredients;
        burger.addIngredient(ingredient);
        verify(mockIngredients).add(ingredient);
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients = mockIngredients;
        int index = 0;
        burger.removeIngredient(index);
        verify(mockIngredients).remove(index);
    }

    @Test
    public void testMoveIngredient() {
        burger.ingredients = mockIngredients;
        int index = 0;
        int newIndex = 1;
        burger.moveIngredient(index, newIndex);
        verify(mockIngredients).add(newIndex, mockIngredients.remove(index));
    }

    @Test
    public void testGetPrice() {
        float price = 6.0f;
        when(bun.getPrice()).thenReturn(2.0f);
        when(ingredient.getPrice()).thenReturn(1.0f);
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        assertEquals(price, burger.getPrice(), 0.0f);
    }

    @Test
    public void testGetReceipt() {
        StringBuilder receiptExpect = new StringBuilder();

        when(bun.getName()).thenReturn("Test");
        when(ingredient.getName()).thenReturn("Test");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String header = String.format("(==== %s ====)%n", bun.getName());
        String price = String.format("%nPrice: %f%n", burger.getPrice());
        String ingredient = String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), "Test");

        receiptExpect.append(header);
        receiptExpect.append(ingredient);
        receiptExpect.append(header);
        receiptExpect.append(price);
        assertEquals(receiptExpect.toString(), burger.getReceipt());
    }

}
