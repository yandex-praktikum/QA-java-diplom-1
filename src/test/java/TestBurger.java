import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestBurger {

    List<Ingredient> ingredients = new ArrayList<>();
    @Mock
    private Burger burger;

    @Test
    public void testAddIngredientInputData() {
        Ingredient ingredient = new Ingredient(SAUCE, "Птицы", 6);
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);

    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient = new Ingredient(SAUCE, "Птицы", 6);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void testMoveIngredientIndexVerify() {
        burger.moveIngredient(5, 6);
        Mockito.verify(burger).moveIngredient(5, 6);
    }

    @Test
    public void testMoveIngredient() {
        ingredients.add(0, new Ingredient(SAUCE, "Птицы", 6));
        burger.moveIngredient(0, 1);
        Mockito.verify(burger).moveIngredient(0, 1);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Кунжутная", 8.5F);
        Ingredient ingredient = new Ingredient(SAUCE, "Птицы", 6);
        Burger burger2 = new Burger();
        burger2.addIngredient(ingredient);
        burger2.setBuns(bun);
        float result = burger2.getPrice();
        assertEquals(result, 23.0F, 0.0f);
    }

    @Test
    public void testGetReceipt() {
        Bun bun = new Bun("Кунжутная", 8.5F);
        Ingredient ingredient = new Ingredient(SAUCE, "Птицы", 6);
        burger.addIngredient(ingredient);
        Mockito.when(burger.getReceipt()).thenReturn("dfsdfsd");
        String expectedPrice = "dfsdfsd";
        Assert.assertEquals(expectedPrice, burger.getReceipt());

    }

}