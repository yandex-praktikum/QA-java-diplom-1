import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    Burger burger;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testIngredientAddedInBurger() {

        burger = new Burger();
        burger.addIngredient(ingredient);

        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);

        int delta = 2;

        IngredientType actualIngredientType = burger.ingredients.get(0).getType();
        String actualIngredientName = burger.ingredients.get(0).getName();
        float actualIngredientPrice = burger.ingredients.get(0).getPrice();

        IngredientType expectedIngredientType = SAUCE;
        String expectedIngredientName = "hot sauce";
        float expectedIngredientPrice = 100.0f;

        assertEquals(expectedIngredientType, actualIngredientType);
        assertEquals(expectedIngredientName, actualIngredientName);
        assertEquals(expectedIngredientPrice, actualIngredientPrice, delta);
    }

    @Test
    public void testIngredientCanBeRemove() {
        burger = new Burger();
        int index = 0;

        burger.addIngredient(ingredient);
        burger.removeIngredient(index);

        burger.ingredients.isEmpty();

    }

    @Test
    public void testIngredientCanBeMove() {

        burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        Mockito.when(firstIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("sour cream");
        Mockito.when(firstIngredient.getPrice()).thenReturn(200.0f);

        Mockito.when(secondIngredient.getType()).thenReturn(FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("sausage");
        Mockito.when(secondIngredient.getPrice()).thenReturn(300.0f);

        int index = 0;
        int newIndex = 1;
        burger.moveIngredient(index, newIndex);

        IngredientType actualIngredientType = burger.ingredients.get(0).getType();
        String actualIngredientName = burger.ingredients.get(0).getName();
        float actualIngredientPrice = burger.ingredients.get(0).getPrice();

        IngredientType expectedIngredientType = FILLING;
        String expectedIngredientName = "sausage";
        float expectedIngredientPrice = 300.0f;

        int delta = 2;

        assertEquals(expectedIngredientType, actualIngredientType);
        assertEquals(expectedIngredientName, actualIngredientName);
        assertEquals(expectedIngredientPrice, actualIngredientPrice, delta);

    }

    @Test
    public void testGetPriceForBurger() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100.0f); // Эта цена умножится на 2
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);

        float burgerActualPrice = burger.getPrice();
        float burgerExpectedPrice = 300.0f;
        int delta = 2;

        assertEquals(burgerExpectedPrice, burgerActualPrice, delta);

    }

    @Test
    public void testGetReceiptBurger() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(burger.getPrice()).thenReturn(200.0f);

        String actualReceipt = burger.getReceipt();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "white bun"));
        expectedReceipt.append(String.format("= %s %s =%n", "filling", "cutlet"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "white bun"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 200.0f));

        assertEquals(expectedReceipt.toString(), actualReceipt);

    }

}
