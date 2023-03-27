package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        for (int i = 0; i <= 3; i++) {
            if (i == 2) {
                burger.ingredients.add(secondIngredient);
            } else {
                burger.ingredients.add(firstIngredient);
            }
        }
    }

    @Test
    public void setBunShouldSetPassedBun() {
        Mockito.when(bun.getName()).thenReturn("TestBun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        assertEquals("TestBun", burger.bun.getName());
        assertEquals(100f, burger.bun.getPrice(), 0);
    }

    @Test
    public void addIngredientShouldIncreaseAmountOfIngredientsByOne() {
        int ingredientsBeforeSnapshot = burger.ingredients.size();
        burger.addIngredient(firstIngredient);
        int ingredientsAfterSnapshot = burger.ingredients.size();
        assertEquals(1, ingredientsAfterSnapshot - ingredientsBeforeSnapshot);
    }

    @Test
    public void moveIngredientShouldMoveElementToChosenPosition() {
        burger.moveIngredient(2, 0);
        assertSame(burger.ingredients.get(0), secondIngredient);
    }

    @Test
    public void removeIngredientShouldRemoveIngredientPassedIndex() {
        burger.removeIngredient(2);
        assertEquals(3, burger.ingredients.size());
        assertSame(burger.ingredients.get(2), burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientShouldNotChangeIngredientsSize() {
        int expectedResult = burger.ingredients.size();
        burger.moveIngredient(2, 0);
        assertEquals(burger.ingredients.size(), expectedResult);
    }

    @Test
    public void getPriceShouldReturnValidResult() {
        Mockito.when(bun.getPrice()).thenReturn(25f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(5f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(5f);
        burger.bun = bun;
        float expectedResult = 25f * 2 + 5f * 4;
        float actualResult = burger.getPrice();
        assertEquals(actualResult, expectedResult, 0f);
    }

    @Test
    public void getReceiptShouldReturnValidFormat() {
        burger.bun = bun;
        String mockBunName = "BigBun";
        String mockFirstIngredientName = "SpaceSauce";
        String mockSecondIngredientName = "CheeseWithMould";
        Mockito.when(bun.getName()).thenReturn(mockBunName);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(mockFirstIngredientName);
        Mockito.when(secondIngredient.getName()).thenReturn(mockSecondIngredientName);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(25f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(5f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(5f);

        StringBuilder expectedResult = new StringBuilder(String.format("(==== %s ====)%n", mockBunName));
        for (Ingredient ingredient : burger.ingredients) {
            expectedResult.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        expectedResult.append(String.format("(==== %s ====)%n", mockBunName));
        expectedResult.append(String.format("%nPrice: %f%n", 70f));
        assertEquals(expectedResult.toString(), burger.getReceipt());
    }
}
