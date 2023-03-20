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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "ingredientNameTest", 100F);

    @Test
    public void setBunsInBurger() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("testName");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        assertEquals(bun.getName(), burger.bun.getName());
        assertEquals(bun.getPrice(), burger.bun.getPrice(), 0);
    }

    @Test
    public void addIngredientInIngredientsBurger() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientInIngredientsBurger() {
        burger.ingredients.add(ingredient);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientIndexInIngredientsBurger() {
        burger.ingredients.add(ingredient);
        Ingredient ingredientSecond = new Ingredient(IngredientType.SAUCE, "SecondIngredient", 200F);
        burger.ingredients.add(ingredientSecond);
        assertEquals(0, burger.ingredients.indexOf(ingredient));
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void getPriceBurger() {
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurger() {
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(150F);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) + String.format("(==== %s ====)%n", bun.getName()) + String.format("%nPrice: %f%n", expectedPrice);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}