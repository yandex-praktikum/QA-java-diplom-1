package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class ParametrizedBurgerTest {

    private final String bunName;
    private final float bunPrice;
    private final float ingredient1Price;
    private final String ingredient1Name;
    private final IngredientType ingredient1Type;
    private final float ingredient2Price;
    private final String ingredient2Name;
    private final IngredientType ingredient2Type;
    private final float expectedPriceWithoutIngredients;
    private final float expectedPriceWithIngredients;
    private final String expectedReceipt;
    @InjectMocks
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    public ParametrizedBurgerTest(
            String bunName, float bunPrice,
            float ingredient1Price, String ingredient1Name, IngredientType ingredient1Type,
            float ingredient2Price, String ingredient2Name, IngredientType ingredient2Type,
            float expectedPriceWithoutIngredients, float expectedPriceWithIngredients, String expectedReceipt
    ) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredient1Price = ingredient1Price;
        this.ingredient1Name = ingredient1Name;
        this.ingredient1Type = ingredient1Type;
        this.ingredient2Price = ingredient2Price;
        this.ingredient2Name = ingredient2Name;
        this.ingredient2Type = ingredient2Type;
        this.expectedPriceWithoutIngredients = expectedPriceWithoutIngredients;
        this.expectedPriceWithIngredients = expectedPriceWithIngredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 2.0f, 1.5f, "Ketchup", SAUCE, 0.5f, "Chicken", FILLING, 4.0f, 6.0f,
                        String.format("(==== black bun ====)%n" +
                                "= sauce Ketchup =%n" +
                                "= filling Chicken =%n" +
                                "(==== black bun ====)%n" +
                                "%nPrice: 6,000000%n")},
                {"white bun", 15.0f, 6.0f, "Mayo", SAUCE, 4.0f, "Falafel", FILLING, 30.0f, 40.0f,
                        String.format("(==== white bun ====)%n" +
                                "= sauce Mayo =%n" +
                                "= filling Falafel =%n" +
                                "(==== white bun ====)%n" +
                                "%nPrice: 40,000000%n")},// Добавьте другие тестовые данные, если необходимо
        });
    }

    @Before
    public void setUp() {
        // Инициализация моков для теста
        burger = new Burger();
        ingredient1 = Mockito.mock(Ingredient.class);
        ingredient2 = Mockito.mock(Ingredient.class);
        bun = Mockito.mock(Bun.class);

        // Настройка мока bun
        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);

        // Настройка моков для ингредиентов.
        when(ingredient1.getPrice()).thenReturn(ingredient1Price);
        when(ingredient1.getName()).thenReturn(ingredient1Name);
        when(ingredient1.getType()).thenReturn(ingredient1Type);

        when(ingredient2.getPrice()).thenReturn(ingredient2Price);
        when(ingredient2.getName()).thenReturn(ingredient2Name);
        when(ingredient2.getType()).thenReturn(ingredient2Type);
    }

    // Тест проверяет метод getPrice без ингредиентов
    @Test
    public void testGetPriceWithoutIngredients() {
        burger.setBuns(bun);
        // Проверка, что цена бургера правильно вычислена без ингредиентов
        assertEquals(expectedPriceWithoutIngredients, burger.getPrice(), 0.001);
    }

    // Тест проверяет метод getPrice с ингредиентами
    @Test
    public void testGetPriceWithIngredients() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        // Проверка, что цена бургера правильно вычислена с ингредиентами
        assertEquals(expectedPriceWithIngredients, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
