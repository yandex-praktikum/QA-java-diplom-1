package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    public Bun getBunMock() {
        Bun createdBunMock = Mockito.mock(Bun.class);
        Mockito.when(createdBunMock.getPrice()).thenReturn(10.0f);
        Mockito.when(createdBunMock.getName()).thenReturn("Вкусненькая булочка");
        return createdBunMock;
    }

    public Ingredient getFirstIngredientMock() {
        Ingredient createdIngredientMock = Mockito.mock(Ingredient.class);
        Mockito.when(createdIngredientMock.getName()).thenReturn("Вкусная котлетка");
        Mockito.when(createdIngredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(createdIngredientMock.getPrice()).thenReturn(3.27f);
        return createdIngredientMock;
    }

    public Ingredient getSecondIngredientMock() {
        Ingredient createdIngredientMock = Mockito.mock(Ingredient.class);
        Mockito.when(createdIngredientMock.getName()).thenReturn("Вкусный соус");
        Mockito.when(createdIngredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(createdIngredientMock.getPrice()).thenReturn(1.23f);
        return createdIngredientMock;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsCanBeEqualMockData() {
        Bun expectedBun = getBunMock();
        burger.setBuns(expectedBun);
        assertEquals("Булочки не совпадают", expectedBun, burger.bun);
    }

    @Test
    public void addIngredientCanBeEqual() {
        Ingredient exoectedIngredient = getFirstIngredientMock();
        burger.addIngredient(exoectedIngredient);
        assertEquals("Ингредиент не добавился", exoectedIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeOnlyIngredientGetEmpty() {
        Ingredient exoectedIngredient = getFirstIngredientMock();
        burger.addIngredient(exoectedIngredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиет не удалился", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientWithMockData() {
        Ingredient firstIngredient = getFirstIngredientMock();
        Ingredient secondIngredient = getSecondIngredientMock();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент не переместился", firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceCanBeEqualMockData() {
        Bun bunMock = getBunMock();
        Ingredient firstIngredient = getFirstIngredientMock();
        burger.setBuns(bunMock);
        burger.addIngredient(firstIngredient);
        float expectedPrice = bunMock.getPrice()*2 + firstIngredient.getPrice();
        assertEquals("Цены бургера не совпадают", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptCanBeReturnTrueData() {
        Bun bunMock = getBunMock();
        Ingredient firstIngredient = getFirstIngredientMock();
        Ingredient secondIngredient = getSecondIngredientMock();
        burger.setBuns(bunMock);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expected = "(==== Вкусненькая булочка ====)\n" +
                "= filling Вкусная котлетка =\n" +
                "= sauce Вкусный соус =\n" +
                "(==== Вкусненькая булочка ====)\n\n" +
                "Price: 24,500000\n";
        assertEquals("Рецепты бургеров не совпадают", expected, burger.getReceipt());
    }
}