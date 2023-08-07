package ru.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Collections.singletonList;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    Ingredient ingredient;
    private Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(singletonList(ingredient),burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(false, burger.ingredients.isEmpty());
        burger.removeIngredient(0);
        Assert.assertEquals(true, burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientAnyIntTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 100));
        //System.out.println(burger.ingredients.size());
        burger.moveIngredient(0, 1);
        Assert.assertNotNull(burger.ingredients);

    }

    @Test
    public void getPriceTest() {
        burger.setBuns(new Bun("hot sauce", 100));
        float actual = burger.getPrice();
        Assert.assertEquals(200, actual, 1);

    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(new Bun("hot sauce", 100));
        System.out.println(burger.getReceipt());
        Assert.assertNotNull(burger.ingredients);

    }
}
