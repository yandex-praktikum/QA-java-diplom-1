package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    float expectedBunPrice;
    float expectedIngrPrice;
    float expectedBurgerPrice;
    private static int bunId;
    private static float bunPrice;
    private static int sauceId;
    private static float saucePrice;
    private static int fillingId;
    private static float fillingPrice;
    private static float bunExpectedPrice;
    private static float ingrExpectedPrice;

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    public BurgerTest(int bunId, float bunPrice, int sauceId, float saucePrice, int fillingId, float fillingPrice, float bunExpectedPrice, float ingrExpectedPrice) {
        this.bunId = bunId;
        this.bunPrice = bunPrice;
        this.sauceId = sauceId;
        this.saucePrice = saucePrice;
        this.fillingId = fillingId;
        this.fillingPrice = fillingPrice;
        this.bunExpectedPrice = bunExpectedPrice;
        this.ingrExpectedPrice = ingrExpectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: bun[{0}]=price{1}, sauce[{2}]=price{3}, filling[{4}]=price{5}")
    public static Object[][] getBunId() {
        return new Object[][]{
                {0, 100f, 0, 100f, 3, 100f, 100f, 200f},
                {0, 100f, 2, 300f, 4, 200f, 100f, 500f},
                {2, 300f, 0, 100f, 5, 300f, 300f, 400f},
                {1, 200f, 0, 100f, 4, 200f, 200f, 300f},
                {2, 300f, 1, 200f, 3, 100f, 300f, 300f},
                {1, 200f, 1, 200f, 5, 300f, 200f, 500f},
                {0, 100f, 1, 200f, 4, 200f, 100f, 400f},
                {1, 200f, 2, 300f, 3, 100f, 200f, 400f},
                {0, 100f, 2, 300f, 5, 300f, 100f, 600f},
                {2, 300f, 2, 300f, 4, 200f, 300f, 500f},
        };
    }

    @Test
    public void testSetBuns() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(bunId));
        Mockito.when(bun.getPrice()).thenReturn(bunExpectedPrice);
        expectedBunPrice = bun.getPrice() * 2;
        assertEquals("Внимание! Не удалось добавить булочку", expectedBunPrice, burger.getPrice(), 0);
    }

    @Test
    public void testAddIngredient() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(bunId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(fillingId));
        Mockito.when(bun.getPrice()).thenReturn(bunExpectedPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingrExpectedPrice);
        expectedIngrPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals("Внимание! Не удалось добавить ингредиент", expectedIngrPrice, burger.getPrice(), 0);
    }

    @Test
    public void testRemoveIngredient() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(bunId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(fillingId));
        burger.removeIngredient(1);
        Mockito.when(bun.getPrice()).thenReturn(bunExpectedPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingrExpectedPrice);
        expectedBurgerPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals("Внимание! Не удалось удалить ингредиент", expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void testMoveIngredient() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(bunId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(2));
        burger.addIngredient(ingredients.get(3));
        burger.moveIngredient(2, 1);
        assertEquals("Внимание! Не удалось переместить ингредиент на позицию 1", "cutlet", burger.ingredients.get(1).getName());
        assertEquals("Внимание! Не удалось переместить ингредиент с позиции 2", "chili sauce", burger.ingredients.get(2).getName());
    }

    @Test
    public void testGetPrice() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(bunId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(fillingId));
        assertNotEquals("Внимание! Цена бургера некорректна", 0, burger.getPrice());
    }

    @Test
    public void testGetReceipt() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(bunId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(sauceId));
        burger.addIngredient(ingredients.get(fillingId));
        assertFalse("Внимание! Не удалось получить рецепт", burger.getReceipt().isEmpty());
    }
}