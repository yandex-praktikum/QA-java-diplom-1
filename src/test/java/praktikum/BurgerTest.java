package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

/**
 * Author: Alexey Bondarenko
 * Date: 01.06.2022
 */
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final static String NAME = "AlexeyJava";
    private final static String INGREDIENT_NAME = "Space Workflow";
    private final static String ANOTHER_INGREDIENT_NAME = "World Workflow";
    private final static float PRICE = 2.0F;
    private final static String expectedReceipt =
            "(==== %s ====)\n" +
                    "= %s %s =\n" +
                    "= %s %s =\n" +
                    "(==== %s ====)\n\n" +
                    "Price: %f\n";


    private Burger burger;

    @Mock
    Bun bun;

    @Before
    public void init() {
        burger = new Burger();
    }

    public void createBunMockAndSetBunField(String name, Float price) {
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(bun.getName()).thenReturn(name);
        burger.setBuns(bun);
    }

    @Test
    public void checkSetBuns() {
        createBunMockAndSetBunField(NAME, PRICE);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        Ingredient ingredient = new Ingredient(SAUCE, INGREDIENT_NAME, PRICE);
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void checkAddIngredientWithNull() { // Баг, мы не должны иметь возможность добавить Null
        burger.addIngredient(null);
        try {
            assertEquals(List.of(null), burger.ingredients);
        } catch (Exception e) {
            assertEquals("Cannot read the array length because \"elements\" is null", e.getMessage());
        }
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
        burger.removeIngredient(0);
        assertEquals(List.of(), burger.ingredients);
    }

    @Test
    public void checkRemoveIngredientForEmptyIngredientList() {
        try {
            burger.removeIngredient(0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index 0 out of bounds for length 0", e.getMessage());
        }
    }

    @Test
    public void checkGetPrice() {
        createBunMockAndSetBunField(NAME, PRICE);
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
        burger.addIngredient(new Ingredient(SAUCE, ANOTHER_INGREDIENT_NAME, PRICE));
        assertEquals(PRICE * 4, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        createBunMockAndSetBunField(NAME, PRICE);
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
        burger.addIngredient(new Ingredient(SAUCE, ANOTHER_INGREDIENT_NAME, PRICE));
        assertEquals(
                String.format(
                        expectedReceipt,
                        NAME,
                        SAUCE.toString().toLowerCase(Locale.ROOT),
                        INGREDIENT_NAME,
                        SAUCE.toString().toLowerCase(Locale.ROOT),
                        ANOTHER_INGREDIENT_NAME,
                        NAME,
                        burger.getPrice()
                ),
                burger.getReceipt());
    }
}