package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void setBunsSuccessful() {
        Burger burger = new Burger();
        Bun expectedBun = new Bun("С Кунжутом", 5.55f);
        burger.setBuns(expectedBun);
        assertEquals(expectedBun, burger.bun);
    }

    @Test
    public void addIngredientSuccessful() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Картошка", 2.55f);
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientSuccessful() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Картошка", 2.55f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientSuccessful() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Картошка", 2.55f);
        Ingredient secondIngredient = new Ingredient(IngredientType.SAUCE, "Моркошка", 2.66f);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Ingredient result = burger.ingredients.get(1);
        assertEquals(ingredient, result);
    }

    @Mock
    Bun bun;

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Картошка", 2.55f);
        Mockito.when(bun.getPrice()).thenReturn(5.55f);
        burger.addIngredient(ingredient);
        float result = burger.getPrice();
        float expected = 13.65f;
        assertEquals(expected, result, 0.00001);

    }

    @Test
    public void getReceiptShouldReturnCorrectText() {
        Mockito.when(bun.getPrice()).thenReturn(5.55f);
        Mockito.when(bun.getName()).thenReturn("С кунжутом");
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", 2.55f);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "Моркошка", 2.6f);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        String expected = String.format("(==== %s ====)%n", "С кунжутом") +
                String.format("= %s %s =%n", "sauce", "Сырный") +
                String.format("= %s %s =%n", "filling", "Моркошка") +
                String.format("(==== %s ====)%n", "С кунжутом") +
                String.format("%nPrice: %f%n", 16.25);
        assertEquals(expected, burger.getReceipt());
    }
}