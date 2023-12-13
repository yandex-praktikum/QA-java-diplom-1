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
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient;
    @Mock
    Ingredient anotherTestIngredient;
    @Before
    public void setUp() {
        burger = new Burger();
    }
    @Test
    public void setBunsEqual() {
        burger.setBuns(testBun);
        assertEquals(testBun, burger.bun);
    }
    @Test
    public void addIngredientEqual() {
        burger.addIngredient(testIngredient);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void removeIngredientEqual() {
        burger.addIngredient(testIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }
    @Test
    public void moveIngredientEqual() {
        burger.addIngredient(testIngredient);
        burger.addIngredient(anotherTestIngredient);
        List<Ingredient> actual = new ArrayList<>(Arrays.asList(anotherTestIngredient, testIngredient));
        burger.moveIngredient(0, 1);
        assertEquals(actual, burger.ingredients);
    }
    @Test
    public void getPriceBurgerEqual() {
        burger.setBuns(testBun);
        burger.addIngredient(testIngredient);

        Mockito.when(testBun.getPrice()).thenReturn(150.5F);
        Mockito.when(testIngredient.getPrice()).thenReturn(99F);
        assertEquals(400, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptEqual() {
        burger.setBuns(testBun);
        burger.ingredients.add(testIngredient);
        Mockito.when(testBun.getName()).thenReturn("black bun");
        Mockito.when(testBun.getPrice()).thenReturn(125F);
        Mockito.when(testIngredient.getType()).thenReturn(FILLING);
        Mockito.when(testIngredient.getName()).thenReturn("dinosaur");
        Mockito.when(testIngredient.getPrice()).thenReturn(495F);

        String expected = String.format("(==== %s ====)%n"  +
                                        "= %s %s =%n"       +
                                        "(==== %s ====)%n"    +
                                        "%nPrice: %f%n",
                testBun.getName(), testIngredient.getType().toString().toLowerCase(),
                testIngredient.getName(),testBun.getName(), burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }
}
