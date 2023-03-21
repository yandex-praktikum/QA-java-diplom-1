package practicum;

import org.junit.Before;
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
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        for (int i = 0; i <= 3; i++) {
            if (i == 2) {
                burger.ingredients.add(anotherIngredient);
            } else {
                burger.ingredients.add(ingredient);
            }
        }
    }

    @Test
    public void setBunShouldSetPassedBan() {
        Mockito.when(bun.getName()).thenReturn("TestBun");
        Mockito.when(bun.getPrice()).thenReturn(123f);
        burger.setBuns(bun);
        assertEquals(123f, burger.bun.getPrice(), 0);
        assertEquals("TestBun", burger.bun.getName());
    }

    @Test
    public void addIngredientShouldIncreaseAmountOfIngredientsByOne() {
        int ingredientsBeforeSnapshot = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int ingredientsAfterSnapshot = burger.ingredients.size();
        assertEquals(1, ingredientsAfterSnapshot - ingredientsBeforeSnapshot);
    }

    @Test
    public void removeIngredientShouldRemoveIngredientAtPassedIndex() {
        burger.removeIngredient(2);
        assertEquals(3, burger.ingredients.size());
        assertSame(burger.ingredients.get(2), burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientShouldMoveElementToChosenPosition() {
        burger.moveIngredient(2, 0);
        assertSame(burger.ingredients.get(0), anotherIngredient);
    }

    @Test
    public void moveIngredientShouldNotChangeIngredientsSize() {
        int expectedResult = burger.ingredients.size();
        burger.moveIngredient(2, 0);
        assertEquals(burger.ingredients.size(), expectedResult);
    }

    @Test
    public void getPriceShouldReturnValidResult() {
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Mockito.when(anotherIngredient.getPrice()).thenReturn(2f);
        burger.bun = bun;
        float expectedResult = 5f * 2 + 2f * 4;
        float actualResult = burger.getPrice();
        assertEquals(actualResult, expectedResult, 0f);
    }

    @Test
    public void getReceiptShouldReturnValueOfValidFormat() {
        burger.bun = bun;
        String mockedBunName = "MockedBun";
        String mockedIngredientName = "SecretSauce";
        String mockedAnotherIngredientName = "JucyFilling";
        Mockito.when(bun.getName()).thenReturn(mockedBunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(mockedIngredientName);
        Mockito.when(anotherIngredient.getName()).thenReturn(mockedAnotherIngredientName);
        Mockito.when(anotherIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Mockito.when(anotherIngredient.getPrice()).thenReturn(2f);

        StringBuilder expectedResult = new StringBuilder(String.format("(==== %s ====)%n", mockedBunName));
        for (Ingredient ingredient : burger.ingredients) {
            expectedResult.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        expectedResult.append(String.format("(==== %s ====)%n", mockedBunName));
        expectedResult.append(String.format("%nPrice: %f%n", 18f));
        assertEquals(expectedResult.toString(), burger.getReceipt());
    }
}