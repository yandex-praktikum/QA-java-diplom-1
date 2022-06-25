import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Bun bun;
    private Burger burger;
    private Ingredient ingredient;
    private Ingredient ingredient1;

    @Before
    public void setUp() {
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        ingredient1 = Mockito.mock(Ingredient.class);
    }

    @Test
    public void testDefaultBunIsNull() {
        burger = new Burger();
        String message = "Бургер создался с какой-то неизвестной булочкой";
        Bun actual = burger.bun;
        Assert.assertNull(message, actual);
    }

    @Test
    public void testDefaultIngredientsAreEmptyList() {
        burger = new Burger();
        String message = "Бургер создался с неизвестными ингредиентами";
        List<Ingredient> actual = burger.ingredients;
        Assert.assertTrue(message, actual.isEmpty());
    }

    @Test
    public void testSetBun() {
        burger = new Burger();
        burger.setBuns(bun);
        Bun actual = burger.bun;
        String message = "Метод setBuns присвоил некорректную булочку";
        Assert.assertEquals(message, bun, actual);
    }

    @Test
    public void testChangeBun() {
        burger = new Burger();
        burger.setBuns(bun);

        Bun newBun = Mockito.mock(Bun.class);
        burger.setBuns(newBun);
        Bun actual = burger.bun;
        String message = "Метод setBuns не изменил старую булочку на новую";
        Assert.assertEquals(message, newBun, actual);
    }

    @Test
    public void testAddFirstIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        String message = "Метод addIngredient не добавил новый ингредиент";
        Assert.assertTrue(message, burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger = new Burger();

        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        String message = "Метод removeIngredient не удалил указанный ингредиент";
        Assert.assertTrue(message,
                burger.ingredients.contains(ingredient1) && !burger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);
        burger.moveIngredient(0, 1);
        String message = "Метод moveIngredient не поменял местами ингредиенты";
        Assert.assertTrue(message,
                burger.ingredients.get(0) == ingredient1 && burger.ingredients.get(1) == ingredient);
    }

    @Test
    public void testGetReceipt(){
        burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);

        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(ingredient.getName()).thenReturn("Грибной соус");
        Mockito.when(ingredient1.getName()).thenReturn("Куриная котлетка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(burger.getPrice()).thenReturn(500.0f);

        String expected = String.format("(==== Булочка с кунжутом ====)%n") + String.format("= sauce Грибной соус =%n") +
                String.format("= filling Куриная котлетка =%n") +
                String.format("(==== Булочка с кунжутом ====)%n") +
                String.format("%nPrice: 500,000000%n");

        String actual = burger.getReceipt();

        String message = "Метод getReceipt вернул неправильный бургер. ";
        Assert.assertEquals(message, expected, actual);
    }


}
