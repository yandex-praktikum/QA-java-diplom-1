package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Burger burgerMock;
    @Mock
    Ingredient ingredientsMock;
    @Mock
    Ingredient ingredientWithIndexOneMock;
    @Mock
    IngredientType ingredientTypeMock;

    private final static float BUN_PRICE = 5F;
    private final static float INGREDIENT_PRICE = 7F;
    private final static String EXPECTED_BURGER_PRICE = "17";
    private final static String BUN_NAME = "Вкусная булочка";
    private final static String INGREDIENT_NAME = "Горчица";


    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        assertEquals("Булочки не совпадают", bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientsMock);
        assertTrue("Ингредиент не был добавлен", burger.ingredients.contains(ingredientsMock));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientsMock);
        burger.removeIngredient(0);

        assertFalse("Ингредиент не был удален", burger.ingredients.contains(ingredientsMock));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientsMock);
        burger.addIngredient(ingredientWithIndexOneMock);
        burger.moveIngredient(0, 1);

        assertEquals("индекс ингредиента не изменился", 1, burger.ingredients.indexOf(ingredientsMock));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();

        Mockito.when(bunMock.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredientsMock.getPrice()).thenReturn(INGREDIENT_PRICE);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientsMock);
        burger.getPrice();

        Mockito.verify(bunMock).getPrice();
        Mockito.verify(ingredientsMock).getPrice();
        assertEquals("Стоимость бургера не совпадает с ожидаемой", Float.valueOf(EXPECTED_BURGER_PRICE), burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientsMock);

        Mockito.when(bunMock.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredientsMock.getType()).thenReturn(ingredientTypeMock.valueOf("SAUCE"));
        Mockito.when(ingredientsMock.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredientsMock.getPrice()).thenReturn(Float.valueOf(EXPECTED_BURGER_PRICE));

        burger.getReceipt();

        Mockito.verify(bunMock, Mockito.times(2)).getName();
        Mockito.verify(ingredientsMock).getType();
        Mockito.verify(ingredientsMock).getName();
        assertTrue("Рецепт не содержит названия булочки", burger.getReceipt().contains(BUN_NAME));
        assertTrue("Рецепт не содержит типа ингредиента", burger.getReceipt().contains("sauce"));
        assertTrue("Рецепт не содержит названия ингредиента", burger.getReceipt().contains(INGREDIENT_NAME));
        assertTrue("Рецепт не содержит общей стоимости", burger.getReceipt().contains(EXPECTED_BURGER_PRICE));
    }
}