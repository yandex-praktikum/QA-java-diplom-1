import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    float bunPrice;
    float ingredientPrice;

    @Before
    public void setup() {
        Random r = new Random();
        bunPrice = 0 + r.nextFloat() * (5);
        ingredientPrice = 0 + r.nextFloat() * (5);
        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);

        when(bun.getName()).thenReturn("Bun");
        when(ingredient.getName()).thenReturn("first ingredient");

        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }
    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0000001f);
    }

    @Test
    public void getRecipeTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();

        String expectedReceipt =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", expectedPrice);

        assertEquals(expectedReceipt,burger.getReceipt());
    }
}
