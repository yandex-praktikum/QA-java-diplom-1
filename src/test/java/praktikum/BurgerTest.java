package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    Burger burger;

    public Ingredient getMockedIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    public Bun getMockedBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun expected = getMockedBun("black bun", 100);
        burger.setBuns(expected);
        Assert.assertEquals("Ожидаемый бургер - \"black bun\" по цене 100", expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient expected = getMockedIngredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Ожидаемый FILLING - \"cutlet\" и по цене 100", expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Ожидается бургер без ингредиентов", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = getMockedIngredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredient2 = getMockedIngredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("В бургере ожидается \"hot sauce\"", ingredient1.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = getMockedBun("black bun", 100);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, "cutlet", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals("Ожидаемя цена за бургер - 300", 300, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = getMockedBun("black bun", 100);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, "hot sauce", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== black bun ====)%n" +
                "= filling hot sauce =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 300,000000%n");
        Assert.assertEquals("Ожидаемый рецепт бургера - " + expected, expected, actual);
    }
}