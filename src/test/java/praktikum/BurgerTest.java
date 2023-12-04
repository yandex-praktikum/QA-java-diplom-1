package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest
{
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Mock
    Ingredient ingredientThree;

    @Test
    public void burgerIsEmptyByDefault()
    {
        Burger burger = new Burger();

        assertThat(burger.bun, nullValue());
        assertThat(burger.ingredients.size(), is(0));
    }

    @Test
    public void bumAppliedToBurgerSuccessful()
    {
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertThat(burger.bun, is(bun));
    }

    @Test
    public void addIngredientsToBurgerSuccessful()
    {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);

        assertThat(burger.ingredients.size(), is(3));
        assertThat(burger.ingredients.get(0), is(ingredientOne));
        assertThat(burger.ingredients.get(1), is(ingredientTwo));
        assertThat(burger.ingredients.get(2), is(ingredientThree));
    }

    @Test
    public void removeIngredientFromBurgerSuccessful()
    {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);

        burger.removeIngredient(1);

        assertThat(burger.ingredients.size(), is(2));
        assertThat(burger.ingredients.get(0), is(ingredientOne));
        assertThat(burger.ingredients.get(1), is(ingredientThree));
    }

    @Test
    public void moveIngredientsInBurgerSuccessful()
    {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);

        burger.moveIngredient(1, 2);

        assertThat(burger.ingredients.size(), is(3));
        assertThat(burger.ingredients.get(0), is(ingredientOne));
        assertThat(burger.ingredients.get(1), is(ingredientThree));
        assertThat(burger.ingredients.get(2), is(ingredientTwo));
    }

    @Test
    public void getCorrectBurgerPrice()
    {
        float bunPrice = 12;
        float ingredientOnePrice = 15;
        float ingredientTwoPrice = 17;

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredientOne.getPrice()).thenReturn(ingredientOnePrice);
        when(ingredientTwo.getPrice()).thenReturn(ingredientTwoPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        assertThat(burger.getPrice(), is(bunPrice * 2 + ingredientOnePrice + ingredientTwoPrice));
    }

    @Test
    public void getCorrectBurgerReceipt()
    {
        initBunMock(bun, "test bun name", 12);
        initIngredientMock(ingredientOne, IngredientType.SAUCE, "test ingredient one name", 15);
        initIngredientMock(ingredientTwo, IngredientType.FILLING, "test ingredient two name", 17);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        assertThat(burger.getReceipt(), is(
                "(==== test bun name ====)\r\n" +
                        "= sauce test ingredient one name =\r\n" +
                        "= filling test ingredient two name =\r\n" +
                        "(==== test bun name ====)\r\n" +
                        "\r\n" +
                        "Price: 56.000000\r\n"
        ));
    }

    private static void initBunMock(Bun bunMock, String bunName, float bunPrice)
    {
        when(bunMock.getName()).thenReturn(bunName);
        when(bunMock.getPrice()).thenReturn(bunPrice);
    }

    private static void initIngredientMock(Ingredient ingredientMock, IngredientType ingredientType, String ingredientName, float ingredientPrice)
    {
        when(ingredientMock.getType()).thenReturn(ingredientType);
        when(ingredientMock.getName()).thenReturn(ingredientName);
        when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
    }
}
