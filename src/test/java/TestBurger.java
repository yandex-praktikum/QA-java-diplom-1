import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBurger {
    private Burger burger;

    //стаб для булки
    public Bun getMockedBun() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("red bun");
        when(bunMock.getPrice()).thenReturn(300f);
        return bunMock;
    }

    //стаб для первого ингредиента
    public Ingredient getMockedFirstIngredient() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("hot sauce");
        when(ingredientMock.getPrice()).thenReturn(100f);
        return ingredientMock;
    }

    //стаб для второго ингредиента
    public Ingredient getMockedSecondIngredient() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("cutlet");
        when(ingredientMock.getPrice()).thenReturn(100f);
        return ingredientMock;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSetBunsWithMockData() {
        Bun bunExpected = getMockedBun();
        burger.setBuns(bunExpected);
        Assert.assertEquals(bunExpected, burger.bun);

    }

    @Test
    public void checkAddIngredientWithMockData() {
        Ingredient ingredientExpected = getMockedFirstIngredient();
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected, burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredientWithMockData() {
        Ingredient ingredient = getMockedFirstIngredient();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredientWithMockData() {
        Ingredient firstIngredient = getMockedFirstIngredient();
        Ingredient secondIngredient = getMockedSecondIngredient();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void checkGetPriceWithMockData() {
        Bun bunForTest = getMockedBun();
        Ingredient ingredient = getMockedFirstIngredient();
        burger.setBuns(bunForTest);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals(700, actual, 0);
    }

    @Test
    public void checkGetReceiptWithMockData() {
        Bun bunForTest = getMockedBun();
        Ingredient ingredient = getMockedFirstIngredient();
        burger.setBuns(bunForTest);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== red bun ====)%n" +
                "= sauce hot sauce =%n" +
                "(==== red bun ====)%n" +
                "%n" +
                "Price: 700,000000%n");
        Assert.assertEquals(expected, actual);
    }
}
