package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {
    @Mock
    private Bun mockBun;
    private Burger burger;

    private List<Ingredient> mockIngredients = new ArrayList<>();

    private float bunPrice;
    private float expectedPrice;
    private String expectedReceipt;
    private int countIngredients;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100.0f, 800.0f, "(==== black bun ====)" + System.lineSeparator() + "= sauce sour cream =" + System.lineSeparator() +
                        "= sauce chili sauce =" + System.lineSeparator() + "= filling cutlet =" + System.lineSeparator() +
                        "(==== black bun ====)" + System.lineSeparator() + System.lineSeparator() + "Price: 800,000000" + System.lineSeparator(), 3},
                {100.0f, 1000.0f, "(==== black bun ====)" + System.lineSeparator() + "= sauce sour cream =" + System.lineSeparator() +
                        "= sauce chili sauce =" + System.lineSeparator() + "= filling cutlet =" + System.lineSeparator() + "= filling dinosaur =" + System.lineSeparator() +
                        "(==== black bun ====)" + System.lineSeparator() + System.lineSeparator() + "Price: 1000,000000" + System.lineSeparator(), 4}
        });
    }

    public BurgerTest(float bunPrice, float expectedPrice, String expectedReceipt, int countIngredients) {
        this.bunPrice = bunPrice;
        this.expectedPrice = expectedPrice;
        this.expectedReceipt = expectedReceipt;
        this.countIngredients = countIngredients;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockBun.getName()).thenReturn("black bun");

        mockIngredients.clear();  // Очищаем список перед добавлением ингредиентов

        for (int i = 0; i < countIngredients; i++) {
            // Используем разные ингредиенты с разными ценами
            mockIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
            mockIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
            mockIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
            mockIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        }

        burger = new Burger();
        burger.setBuns(mockBun);
        burger.ingredients.addAll(mockIngredients.subList(0, countIngredients));
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        assertEquals(expectedReceipt, burger.getReceipt());
    }
    @Test
    public void testAddIngredient() {
        int sizePlus = burger.ingredients.size() + 1;

        Ingredient newIngredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
        burger.addIngredient(newIngredient);

        assertEquals(sizePlus, burger.ingredients.size());
        assertEquals(newIngredient, burger.ingredients.get(sizePlus - 1));
        assertEquals(expectedPrice + 300, burger.getPrice(), 0.01);
    }
    @Test
    public void testRemoveIngredient() {
        int sizeMinus = burger.ingredients.size() - 1;
        int indexToRemove = 1;
        Ingredient removedIngredient = burger.ingredients.get(indexToRemove);

        burger.removeIngredient(indexToRemove);

        assertEquals(sizeMinus, burger.ingredients.size());
        assertEquals(false, burger.ingredients.contains(removedIngredient));
        assertEquals(expectedPrice - 300, burger.getPrice(), 0.01);
    }
    @Test
    public void testMoveIngredient() {
        int sizeBefore = burger.ingredients.size();
        int indexToMove = 2;
        int newIndex = 1;

        Ingredient ingredientToMove = burger.ingredients.get(indexToMove);

        burger.moveIngredient(indexToMove, newIndex);

        assertEquals(sizeBefore, burger.ingredients.size());
        assertEquals(ingredientToMove, burger.ingredients.get(newIndex));
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }
}