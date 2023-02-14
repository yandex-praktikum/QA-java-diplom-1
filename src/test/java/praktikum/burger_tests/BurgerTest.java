package praktikum.burger_tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;
    private Bun bunReal;

    @Before
    public void setUp() {
        burger = new Burger();
        Mockito.when(bunMock.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(50.0F);
        Mockito.when(bunMock.getName()).thenReturn("white bun");

    }

    @Test
    public void setBunReturnsBun() {
        bunMock = new Bun("black bun", 100F);
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void setBunReturnsValidBunName() {
        burger.setBuns(bunMock);

        String expectedName = "white bun";
        String actualName = burger.bun.getName();

        assertEquals(expectedName, actualName);

    }

    @Test
    public void setBunReturnsValidBunPrice() {
        burger.setBuns(bunMock);

        float expectedPrice = 100.0F;
        float actualPrice = burger.bun.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void setBunNullReturnsNullBun() {
        //следует ограничить возможность устанавливать булки с null
        burger.setBuns(bunReal);
        assertThat("Должен видеть объект null", bunReal, is(nullValue()));

    }

    @Test(expected = NullPointerException.class)
    public void getPriceNoBunNoIngredientsShowsException() {
        burger.getPrice();
    }

    @Test
    public void getPriceBunOnlyReturnBurgerPrice() {
        burger.setBuns(bunMock);

        float expectedPrice = 200.0F; //bunPrice * 2
        float actualPrice = burger.getPrice();

        assertEquals("Ожидается цена с учетом булки", expectedPrice, actualPrice, 0);

    }

    @Test
    public void getPriceBunAndOneIngredientReturnBurgerPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        float expectedPrice = 250.0F; //bunPrice * 2 + each ingredientPrice
        float actualPrice = burger.getPrice();

        assertEquals("Ожидается цена с учетом булки и 1 ингридиента", expectedPrice, actualPrice, 0);

    }

    @Test
    public void getPriceBunAndMoreThan1IngredientReturnBurgerPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);

        float expectedPrice = 300.0F; //bunPrice * 2 + each ingredientPrice
        float actualPrice = burger.getPrice();

        assertEquals("Ожидается цена с учетом булки и более 1 ингридиента", expectedPrice, actualPrice, 0);

    }

    @Test
    public void getPriceBunAnd1IngredientRemovedReturnBurgerPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);

        float expectedPrice = 200.0F; //bunPrice * 2 + each ingredientPrice - price of removed ingredient
        float actualPrice = burger.getPrice();

        assertEquals("Ожидается цена с учетом булки и удаленного ингридиента", expectedPrice, actualPrice, 0);

    }

}