package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

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
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        int expectedSizeOfIngredients = 1;

        int actualSizeOfIngredients = burger.ingredients.size();

        assertEquals(expectedSizeOfIngredients, actualSizeOfIngredients);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        int expectedSizeOfIngredientsAfterRemove = 0;

        burger.removeIngredient(0);
        int actualSizeOfIngredientsAfterRemove = burger.ingredients.size();

        assertEquals(expectedSizeOfIngredientsAfterRemove, actualSizeOfIngredientsAfterRemove);
    }

    @Test
    public void moveIngredient() {
        prepareBurger();
        Ingredient expectedIngredient = new Ingredient(IngredientType.SAUCE, "Нужная булочка", 100f);
        burger.addIngredient(expectedIngredient);

        burger.moveIngredient(3, 0);
        Ingredient actualIngredient = burger.ingredients.get(0);

        assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        burger.setBuns(bun);
        float expectedPrice = 30f;
        Mockito.when(bun.getPrice()).thenReturn(expectedPrice);
        float actualPrice = burger.getPrice();
        expectedPrice = expectedPrice * 2;
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String bunName = "Булочка";
        IngredientType ingredientType = IngredientType.valueOf("SAUCE");
        String ingredientName = "Сыр";
        float expectedPrice = 60f;
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(30f);

        StringBuilder tmpReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));
        tmpReceipt.append(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("%nPrice: %f%n", expectedPrice));
        String expectedReceipt = tmpReceipt.toString();

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    private void prepareBurger() {
        for (int i = 0; i != 3; i++) {
            burger.addIngredient(new Ingredient(IngredientType.FILLING, "Булочка с корицей " + 1, 50f));
        }
    }
}