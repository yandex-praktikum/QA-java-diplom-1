package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Ingredient ingredientMock = Mockito.mock(Ingredient.class);
    @Mock
    Bun bunMock = Mockito.mock(Bun.class);
    private final IngredientType type;
    private final String name;
    private final float price;

    public BurgerTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getIngredients() {
        return new Object[][]{
                {SAUCE, "name0", 2.0f},
                {FILLING, "name1", 1.0f}, // передали тестовые данные
        };
    }


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void setBuns() {
    }


    @Test
    public void addIngredient() {
        ingredientMock.type = type;
        ingredientMock.name = name;
        ingredientMock.price = price;
        burger.addIngredient(ingredientMock);
        assertThat(burger.ingredients, notNullValue());
    }


    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertThat(burger.ingredients.size(), equalTo(0));
    }

    //я честно хз как сделать проще чтобы переместились ингредиенты, чтобы руками не добавлять
    @Test
    public void moveIngredient() {
        Ingredient ingredientMock0 = Mockito.mock(Ingredient.class);
        Ingredient ingredientMock1 = Mockito.mock(Ingredient.class);

        Mockito.when(ingredientMock0.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMock0.getName()).thenReturn("Ketchup");
        Mockito.when(ingredientMock0.getPrice()).thenReturn(0.5f);

        Mockito.when(ingredientMock1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMock1.getName()).thenReturn("Cheese");
        Mockito.when(ingredientMock1.getPrice()).thenReturn(1.0f);

        Burger burger = new Burger();
        burger.addIngredient(ingredientMock0);
        burger.addIngredient(ingredientMock1);

        burger.moveIngredient(0, 1);

        // Проверяем, что ингредиенты переместились правильно
        assertEquals(ingredientMock1, burger.ingredients.get(0));
        assertEquals(ingredientMock0, burger.ingredients.get(1));
    }


    @Test
    public void getPrice() {
        Ingredient ingredientMock = Mockito.mock(Ingredient.class);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMock.getName()).thenReturn("Ketchup");
        Mockito.when(ingredientMock.getPrice()).thenReturn(2.0f);

        Mockito.when(bunMock.getName()).thenReturn("Мучная");
        Mockito.when(bunMock.getPrice()).thenReturn(2.00f);

        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.setBuns(bunMock);

        float actualPrice = burger.getPrice();

        float expectedPrice = 6.0f;

        assertThat(actualPrice, equalTo(expectedPrice));
    }

    @Test
    public void getReceipt() {
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMock.getName()).thenReturn("Ketchup");
        Mockito.when(ingredientMock.getPrice()).thenReturn(2.0f);
        Mockito.when(bunMock.getName()).thenReturn("Мучная");
        Mockito.when(bunMock.getPrice()).thenReturn(2.00f);
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.setBuns(bunMock);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Мучная ====)\n" +
                "= sauce Ketchup =\n" +
                "(==== Мучная ====)\n" +
                "\nPrice: 6,000000\n";
        assertThat(actualReceipt, is(expectedReceipt));
    }
}