package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredientSecond;

    @Before
    public void prepareTestData(){
        when(bun.getName()).thenReturn("Булка");
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient.getName()).thenReturn("Соусец");
        when(ingredient.getPrice()).thenReturn(100F);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientSecond.getPrice()).thenReturn(100F);
    }

    @Test
    public void shouldBeEmptyArray(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Почему количество ингредиентов поменялось?", burger.ingredients.isEmpty());
    }

    @Test
    public void shouldBeCorrectPriceOfBurger(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.setBuns(bun);
        float expectedPrice = bun.getPrice()*2 + ingredient.getPrice() + ingredientSecond.getPrice();
        float actualPrice = burger.getPrice();
        assertEquals("Стоимость должна совпасть", expectedPrice, actualPrice, 0);
    }

    @Test
    public void shouldBeCorrectRecipe(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        String expectedRecipe = String.format("(==== %s ====)%n", "Булка") +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", "Булка") +
                String.format("%nPrice: %f%n", bun.getPrice()*2 + ingredient.getPrice());
        String actualRecipe = burger.getReceipt();
        assertEquals("Рецепт не совпадает", expectedRecipe, actualRecipe);
    }
}