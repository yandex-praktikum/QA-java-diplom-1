package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient anotherIngredient;

    @Mock
    Bun bun;

    @Before
    public void prepareData() {
        burger = new Burger();
    }

    @Test
    public void afterSetBunsReturnCorrectBurgerPrice() {
        float bunPrice = 10.6f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float expectedBurgerPrice = bunPrice * 2;

        burger.setBuns(bun);
        float actualBurgerPrice = burger.getPrice();

        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0.0);
    }

    @Test
    public void afterAddIngredientReturnCorrectBurgerPrice() {
        float bunPrice = 10.6f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float twoBunsPrice = bunPrice * 2;

        float ingredientPrice = 258.5f;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        float expectedBurgerPrice = twoBunsPrice + ingredientPrice;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualBurgerPrice = burger.getPrice();

        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0.0);
    }

    @Test
    public void afterAddAndRemoveIngredientReturnCorrectBurgerPrice() {
        float bunPrice = 10.6f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float expectedBurgerPrice = bunPrice * 2;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);
        float actualBurgerPrice = burger.getPrice();

        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0.0);
    }

    @Test
    public void afterMoveAndRemoveIngredientReturnCorrectBurgerPrice() {
        float bunPrice = 10.6f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        float bunsPrice = bunPrice * 2.0f;

        // Добавляю моку двух ингредиентов
        float ingredientPrice = 20f;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        float anotherIngredientPrice = 10f;
        Mockito.when(anotherIngredient.getPrice()).thenReturn(anotherIngredientPrice);

        // Собираю бургер, по очереди добавляя два ингредиента
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);

        // Проверяю, что ингредиенты добавились
        float expectedBurgerPriceAfterAddIngredient = bunsPrice + ingredientPrice + anotherIngredientPrice;
        float actualBurgerPriceAfterAddIngredient = burger.getPrice();
        Assert.assertEquals(expectedBurgerPriceAfterAddIngredient, actualBurgerPriceAfterAddIngredient, 0.0);

        // Меняю местами ингредиенты и удаляю anotherIngredient (ставший первым ингредиентом)
        burger.moveIngredient(0, 1);
        burger.removeIngredient(0);

        // Проверяю, что функция перемещения ингредиентов работает
        // поменяв ингредиенты местами и удалив первый - в итоговой цене учитывается только цена мока ingredient
        float expectedBurgerPrice = bunsPrice + ingredientPrice;
        float actualBurgerPrice = burger.getPrice();

        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0.0);
    }

    @Test
    public void getReceiptReturnCorrectReceipt() {
        float bunPrice = 10f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        String bunName = "Булко";
        Mockito.when(bun.getName()).thenReturn(bunName);

        float ingredientPrice = 258.5f;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        String ingredientName = "Марсианский";
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        IngredientType expectedIngredientType = IngredientType.SAUCE;
        Mockito.when(ingredient.getType()).thenReturn(expectedIngredientType);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();

        String expectedReceipt = String.format("(==== Булко ====)%n= sauce Марсианский =%n(==== Булко ====)%n%nPrice: 278,500000%n");

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
