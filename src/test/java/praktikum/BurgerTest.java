package praktikum;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final String FAILED_SET_BUN_MESSAGE = "Булочка выбрана не правильно";
    private static final String FAILED_ADD_INGREDIENT_MESSAGE = "Ингредиент не добавлен";
    private static final String FAILED_REMOVE_INGREDIENT_MESSAGE = "Ингредиент не удалён";
    private static final String FAILED_MOVE_INGREDIENT_MESSAGE = "Ингредиент не перемещён";
    private static final String FAILED_GET_BURGER_PRICE_MESSAGE = "Цена бургера указана не правильно";
    private static final String FAILED_GET_BURGER_RECEIPT_MESSAGE = "Чек сформирован правильно";

    @Mock
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    @Description("Проверяем выбор булочки")
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(FAILED_SET_BUN_MESSAGE, burger.bun, bun);
    }

    @Test
    @Description("Проверяем возможность добавить ингридиент")
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertNotNull(FAILED_ADD_INGREDIENT_MESSAGE, burger.ingredients);
    }

    @Test
    @Description("Проверяем возможность удалить ингридиент")
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(FAILED_REMOVE_INGREDIENT_MESSAGE, burger.ingredients.isEmpty());
    }

    @Test
    @Description("Проверяем возможность переместить ингридиент")
    public void testMoveIngredient() {
        String str = "Чили";
        Ingredient mock = mock(Ingredient.class, withSettings().name(str));
        burger.addIngredient(mock);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals(FAILED_MOVE_INGREDIENT_MESSAGE, burger.ingredients.get(1).toString(), str);
    }

    @Test
    @Description("Проверяем цену бургера")
    public void testGetBurgerPrice() {
        when(bun.getPrice()).thenReturn(10f);
        when(ingredient.getPrice()).thenReturn(20f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = 40f;
        float actualPrice = burger.getPrice();
        assertEquals(FAILED_GET_BURGER_PRICE_MESSAGE, expectedPrice, actualPrice, 0);
    }

    @Test
    @Description("Проверяем чек")
    public void testGetBurgerReceipt() {
        String bunName = "Кунжутная";
        String ingredientName = "Щавелевый";
        IngredientType ingredientType = IngredientType.SAUCE;

        when(bun.getName()).thenReturn(bunName);
        when(ingredient.getName()).thenReturn(ingredientName);
        when(ingredient.getType()).thenReturn(ingredientType);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                bunName, ingredientType.toString().toLowerCase(), ingredientName, bunName, ingredient.getPrice());
        assertEquals(FAILED_GET_BURGER_RECEIPT_MESSAGE, expectedReceipt, actualReceipt);
    }
}