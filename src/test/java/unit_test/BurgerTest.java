package unit_test;

import date.CreateRandomBun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.*;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Burger burger;
    @Mock
    Ingredient randomIngredient;
    @Mock
    CreateRandomBun createRandomBun;

    float bunPrice = 100f;
    float ingredientPrice;
    float expectedPrice;

    @Before
    public void setUpTest() {
        burger = new Burger();
        burger.setBuns(bun);
        randomIngredient = Mockito.mock(Ingredient.class);
        Mockito.when(randomIngredient.getPrice()).thenReturn(300f);
        ingredientPrice = randomIngredient.getPrice();
        expectedPrice = (bunPrice * 2) + ingredientPrice;
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(randomIngredient);
        assertTrue(burger.ingredients.contains(randomIngredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(randomIngredient);
        burger.removeIngredient(burger.ingredients.size() - 1);
        assertFalse(burger.ingredients.contains(randomIngredient));
    }


    @Test
    public void moveIngredientTest() {
        List<Ingredient> ingredientsList = new ArrayList<>();
        while (burger.ingredients.size() <= 5) {
            randomIngredient = Mockito.mock(Ingredient.class);
            burger.ingredients.add(randomIngredient);
            ingredientsList.add(randomIngredient);
        }
        int newIndex = burger.ingredients.size() - 3;
        burger.moveIngredient(newIndex, 5);
        assertEquals(burger.ingredients.get(5), ingredientsList.get(newIndex));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.addIngredient(randomIngredient);
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Bun mockBun = Mockito.mock(Bun.class);
        String bunName = "Bun name";
        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient sauce1 = Mockito.mock(Ingredient.class);
        Mockito.when(sauce1.getName()).thenReturn("hot sauce");
        Mockito.when(sauce1.getPrice()).thenReturn(100f);
        Mockito.when(sauce1.getType()).thenReturn(SAUCE);
        Ingredient sauce2 = Mockito.mock(Ingredient.class);
        Mockito.when(sauce2.getName()).thenReturn("chili sauce");
        Mockito.when(sauce2.getPrice()).thenReturn(300f);
        Mockito.when(sauce2.getType()).thenReturn(SAUCE);
        Ingredient filling = Mockito.mock(Ingredient.class);
        Mockito.when(filling.getName()).thenReturn("dinosaur");
        Mockito.when(filling.getPrice()).thenReturn(200f);
        Mockito.when(filling.getType()).thenReturn(FILLING);
        ingredients.add(sauce1);
        ingredients.add(sauce2);
        ingredients.add(filling);
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        String expectedReceipt = String.format(("(==== %s ====)%n"), bunName) +
                "= sauce hot sauce =\r\n" +
                "= sauce chili sauce =\r\n" +
                "= filling dinosaur =" +
                String.format("%n(==== %s ====)%n", bunName) +
                String.format("%nPrice: 800,000000%n", expectedPrice);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
