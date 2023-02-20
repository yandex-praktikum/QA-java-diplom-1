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
    List<Ingredient> ingredients;

    @Mock
    private Ingredient ingredient;
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
        ingredients = new ArrayList<>();

        ingredient = new Ingredient(SAUCE, "hot sauce", 100.0f);

        burger.addIngredient(ingredient);
        ingredients.add(ingredient);

        List<Ingredient> actualIngredients = burger.getIngredients();
        List<Ingredient> expectedIngredients = ingredients;

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void testIngredientCanBeRemove() {

        burger = new Burger();
        ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200.0f);
        int index = 0;

        burger.addIngredient(ingredient);
        burger.removeIngredient(index);

        List<Ingredient> actualAbsenceIngredients = burger.getIngredients();
        List<Ingredient> expectedAbsenceIngredients = ingredients;

        assertEquals(expectedAbsenceIngredients, actualAbsenceIngredients);

    }

    @Test
    public void testIngredientCanBeMove() {

        burger = new Burger();
        ingredients = new ArrayList<>();
        Ingredient firstIngredient = new Ingredient(SAUCE, "sour cream", 200.0f);
        Ingredient secondIngredient = new Ingredient(FILLING, "sausage", 300.0f);
        int index = 0;
        int newIndex = 1;

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(index, newIndex);

        ingredients.add(secondIngredient);
        ingredients.add(firstIngredient);

        List<Ingredient> actualDisplacedIngredients = burger.getIngredients();
        List<Ingredient> expectedDisplacedIngredients = ingredients;

        assertEquals(expectedDisplacedIngredients, actualDisplacedIngredients);

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
