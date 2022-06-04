import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    private final float bunPrice = 10;
    private final float ingredientPrice = 15;
    private final String bunName = "Булочка с мясом";
    private final IngredientType ingredientType = IngredientType.FILLING;
    private final String ingredientName = "Tomato";
    private float burgerPrice = bunPrice * 2 + ingredientPrice;

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        float actual = burger.getPrice();
        assertEquals(burgerPrice, actual, 0.01);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String receiptExpected = getReceipt();
        setMocksForReceipt();

        String actualReceipt = burger.getReceipt();
        assertEquals(receiptExpected, actualReceipt);
    }

    private void setMocksForReceipt() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
    }

    private String getReceipt() {
        StringBuilder receiptExpected = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        receiptExpected.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));

        receiptExpected.append(String.format("(==== %s ====)%n", bunName));
        receiptExpected.append(String.format("%nPrice: %f%n", burgerPrice));
        return receiptExpected.toString();
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        IngredientType firstIngredientType = IngredientType.FILLING;
        IngredientType secondIngredientType = IngredientType.FILLING;

        String firstIngredientName = "Сыр";
        String secondIngredientName = "Томат";

        float firstIngredientPrice = 3;
        float secondIngredientPrice = 5;

        Ingredient ingredientFirst = new Ingredient(firstIngredientType, firstIngredientName, firstIngredientPrice);
        Ingredient ingredientSecond = new Ingredient(secondIngredientType, secondIngredientName, secondIngredientPrice);

        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        assertEquals(burger.ingredients.get(0).name, secondIngredientName);
        assertEquals(burger.ingredients.get(1).name, firstIngredientName);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        IngredientType firstIngredientType = IngredientType.FILLING;
        String firstIngredientName = "Сыр";
        float firstIngredientPrice = 3;
        Ingredient ingredientFirst = new Ingredient(firstIngredientType, firstIngredientName, firstIngredientPrice);
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }
}
