import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    //Для проверки методов работы со списком ингридиентов их нельзя мокать.
    //Т.к. между разными замоканными объектами одного класса нет разницы,
    //мы потом не сможем корректно проверить добавление/удаление/перемещение элементов List.
    //поэтому использую реальные объекты.
    static private final Ingredient INGREDIENT_FIRST = new Ingredient(IngredientType.FILLING, "Filling ingredient", 5);
    static private final Ingredient INGREDIENT_SECOND = new Ingredient(IngredientType.SAUCE, "Sauce ingredient", 4);
    static private final Ingredient INGREDIENT_THIRD = new Ingredient(IngredientType.SAUCE, "New sauce ingredient", 6);

    @Mock
    Bun bunFirst;
    @Mock
    Bun bunSecond;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSetBunsWithFirstBun() {
        burger.setBuns(bunFirst);
        assertEquals(bunFirst, burger.bun);
    }

    @Test
    public void checkSetBunsWithSecondBun() {
        burger.setBuns(bunFirst);
        burger.setBuns(bunSecond);
        assertEquals(bunSecond, burger.bun);
    }

    @Test
    public void checkSetBunsWithNull() {
        burger.setBuns(null);
        assertNull(burger.bun);
    }

    @Test
    public void checkAddIngredientWithOneIngredient() {
        List<Ingredient> expectedIngredientsList = Arrays.asList(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_FIRST);
        assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
    }

    @Test
    public void checkAddIngredientWithSeveralDifferentIngredients() {
        List<Ingredient> expectedIngredientsList = Arrays.asList(INGREDIENT_FIRST, INGREDIENT_SECOND);
        burger.addIngredient(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_SECOND);
        assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
    }

    @Test
    public void checkAddIngredientWithTwoIdenticalIngredients() {
        List<Ingredient> expectedIngredientsList = Arrays.asList(INGREDIENT_FIRST, INGREDIENT_SECOND, INGREDIENT_SECOND);
        burger.addIngredient(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_SECOND);
        burger.addIngredient(INGREDIENT_SECOND);
        assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
    }

    @Test
    public void checkAddIngredientWithNull() {
        final Ingredient ingredientNull = null;
        List<Ingredient> expectedIngredientsList = Arrays.asList(ingredientNull);
        burger.addIngredient(ingredientNull);
        assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
    }

    @Test
    public void checkRemoveIngredientWithIndex0() {
        int index = 0;
        List<Ingredient> expectedIngredientsList = Arrays.asList(INGREDIENT_SECOND, INGREDIENT_THIRD);
        burger.addIngredient(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_SECOND);
        burger.addIngredient(INGREDIENT_THIRD);
        burger.removeIngredient(index);
        assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
    }

    @Test
    public void checkRemoveAllIngredients() {
        List<Ingredient> expectedIngredientsList = Arrays.asList();
        burger.addIngredient(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_SECOND);
        burger.addIngredient(INGREDIENT_THIRD);

        for (int i = burger.ingredients.size() - 1; i >= 0; i--) {
            burger.removeIngredient(i);
        }
        assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
    }

    @Test
    public void checkRemoveIngredientWithNotExistIndex() {
        int notExistIndex = 4;
        List<Ingredient> expectedIngredientsList = Arrays.asList(INGREDIENT_FIRST);
        burger.addIngredient(INGREDIENT_FIRST);

        try {
            burger.removeIngredient(notExistIndex);
            assertEquals("Список ингредиентов не совпал с ожидаемым", expectedIngredientsList, burger.ingredients);
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("Произошло исключение IndexOutOfBoundsException", "", thrown.getMessage());
        }
    }

    @Test
    public void checkGetPriceWithValidBunAndIngredients() {
        Mockito.when(bunFirst.getPrice()).thenReturn(1.15f);
        burger.setBuns(bunFirst);

        Mockito.when(ingredient1.getPrice()).thenReturn(1.05f);
        burger.addIngredient(ingredient1);

        Mockito.when(ingredient2.getPrice()).thenReturn(2f);
        burger.addIngredient(ingredient2);

        Mockito.when(ingredient3.getPrice()).thenReturn(0.50f);
        burger.addIngredient(ingredient3);

        float expectedPrice = 5.85f;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetPriceWithEmptyBurgerWithoutBunAndIngredients() {
        float expectedPrice = 0;
        try {
            float actualPrice = burger.getPrice();
            assertEquals(expectedPrice, actualPrice, 0);
        } catch (NullPointerException thrown) {
            assertEquals("Произошло исключение NullPointerException", "", thrown.getMessage());
        }
    }

    @Test
    public void checkGetReceiptWithValidBunAndIngredients() {
        Mockito.when(bunFirst.getPrice()).thenReturn(1.15f);
        Mockito.when(bunFirst.getName()).thenReturn("Tasty cosmo bun");
        burger.setBuns(bunFirst);

        Mockito.when(ingredient1.getPrice()).thenReturn(1.05f);
        Mockito.when(ingredient1.getName()).thenReturn("Small cosmo jam");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient1);

        Mockito.when(ingredient2.getPrice()).thenReturn(2f);
        Mockito.when(ingredient2.getName()).thenReturn("Big cosmo jam");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient2);

        Mockito.when(ingredient3.getPrice()).thenReturn(0.50f);
        Mockito.when(ingredient3.getName()).thenReturn("UFO oil");
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredient3);

        String expectedReceipt = "(==== Tasty cosmo bun ====)\r\n" +
                "= sauce Small cosmo jam =\r\n" +
                "= sauce Big cosmo jam =\r\n" +
                "= filling UFO oil =\r\n" +
                "(==== Tasty cosmo bun ====)\r\n" +
                "\r\n" +
                "Price: 5,850000\r\n" +
                "";

        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void checkGetReceiptWithEmptyBurgerWithoutBunAndIngredients() {
        String actualReceipt;
        String expectedReceipt = "";

        try {
            actualReceipt = burger.getReceipt();
            assertEquals(expectedReceipt, actualReceipt);
        } catch (NullPointerException thrown) {
            assertEquals("Произошло исключение NullPointerException", "", thrown.getMessage());
        }
    }
}