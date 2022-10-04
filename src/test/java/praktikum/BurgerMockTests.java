package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTests {

    Burger testBurger;

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void setup() {
        testBurger = new Burger();
    }

    @Test
    public void testSetBuns() {
        testBurger.setBuns(bun);
        assertEquals(bun, testBurger.bun);
    }

    @Test
    public void testAddIngredient() {
        testBurger.ingredients.add(firstIngredient);
        testBurger.ingredients.add(secondIngredient);
        assertEquals(List.of(firstIngredient, secondIngredient), testBurger.ingredients);
    }

    @Test
    public void testRemoveIngredient() {
        testBurger.ingredients.add(firstIngredient);
        testBurger.ingredients.add(secondIngredient);
        testBurger.removeIngredient(0);
        assertEquals(List.of(secondIngredient), testBurger.ingredients);
    }

    @Test
    public void testMoveIngredient() {
        testBurger.ingredients.add(firstIngredient);
        testBurger.ingredients.add(secondIngredient);
        List <Ingredient> expectedIngredients = new ArrayList<>(Arrays.asList(secondIngredient, firstIngredient));
        testBurger.moveIngredient(0, 1);
        assertEquals(expectedIngredients, testBurger.ingredients);
    }

    @Test
    public void testGetPrice() {
        testBurger.setBuns(bun);
        testBurger.ingredients.add(firstIngredient);
        testBurger.ingredients.add(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(100f);
        assertEquals(700f, testBurger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        testBurger.setBuns(bun);
        testBurger.ingredients.add(firstIngredient);
        testBurger.ingredients.add(secondIngredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(firstIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("sour cream");
        Mockito.when(firstIngredient.getPrice()).thenReturn(200f);
        Mockito.when(secondIngredient.getType()).thenReturn(FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("cutlet");
        Mockito.when(secondIngredient.getPrice()).thenReturn(100f);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(),
                        firstIngredient.getName()) +
                String.format("= %s %s =%n", secondIngredient.getType().toString().toLowerCase(),
                        secondIngredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", testBurger.getPrice());
        assertEquals(expectedReceipt, testBurger.getReceipt());
    }

}
