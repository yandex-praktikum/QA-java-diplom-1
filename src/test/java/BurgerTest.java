import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient1;
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();

        // Создаем моки для булочки и ингредиентов
        mockBun = mock(Bun.class);
        mockIngredient1 = mock(Ingredient.class);
        mockIngredient2 = mock(Ingredient.class);

        // Устанавливаем моки для цены
        when(mockBun.getPrice()).thenReturn(2.5f);
        when(mockIngredient1.getPrice()).thenReturn(2.0f);
        when(mockIngredient2.getPrice()).thenReturn(1.0f);

        // Устанавливаем значения для метода getType()
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void setBuns() {
        burger.setBuns(mockBun);

        assertSame(mockBun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(2, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(mockIngredient1));
        assertTrue(burger.ingredients.contains(mockIngredient2));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(mockIngredient1));
        assertTrue(burger.ingredients.contains(mockIngredient2));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        assertEquals(2, burger.ingredients.size());
        assertSame(mockIngredient2, burger.ingredients.get(0));
        assertSame(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = 2 * mockBun.getPrice() + mockIngredient1.getPrice() + mockIngredient2.getPrice();
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем, что результат содержит ключевые слова
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("(===="));
        assertTrue(receipt.contains("====)"));
        assertTrue(receipt.contains("filling"));
        assertTrue(receipt.contains("sauce"));
        assertTrue(receipt.contains("Price:"));
    }
}