package site.nomoreparties.stellarburgers;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Faker faker = new Faker();

    private final Database database = new Database();
    private final List<Bun> buns = database.availableBuns();
    private final List<Ingredient> ingredients = database.availableIngredients();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsForNameTest() {
        Bun bun = buns.get(faker.number().numberBetween(0, 2));
        String name = bun.getName();

        Burger burger = new Burger();
        burger.setBuns(bun);

        Assert.assertEquals("Set a name is not correct", name, bun.getName());
    }

    @Test
    public void setBunsForPriceTest() {
        Bun bun = buns.get(faker.number().numberBetween(0, 2));
        float price = bun.getPrice();

        Burger burger = new Burger();
        burger.setBuns(bun);

        Assert.assertEquals("Set a price is not correct", price, bun.getPrice(), 0.01);
    }

    @Test
    public void addListIngredientsTest() {
        Ingredient ingredient = ingredients.get(faker.number().numberBetween(0, 5));

        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        Assert.assertEquals("The list of ingredients is not correct", ingredient, burger.ingredients.get(0));
    }


    @Test
    public void removeListIngredientsTest() {
        Ingredient ingredient = ingredients.get(faker.number().numberBetween(0, 5));

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertTrue("The list of ingredients has not been removed", burger.ingredients.isEmpty());
    }

    @Test
    public void moveListIngredientsTest() {
        Burger burger = new Burger();

        for (int i = 0; i < 6; i++) {
            burger.addIngredient(ingredients.get(i));
        }

        int newIndex = faker.number().numberBetween(0, 5);
        Ingredient expected = burger.ingredients.get(5);

        burger.moveIngredient(5, newIndex);

        Assert.assertEquals("The list of ingredients has not been changed", burger.ingredients.get(newIndex), expected);
    }

    @Test
    public void getPriceWithMockTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);

        burger.addIngredient(ingredient);

        float expected = 500F;

        Assert.assertEquals("The price of the burger is not correctly", expected, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        String bunName = faker.space().galaxy();

        Mockito.when(bun.getName()).thenReturn(bunName);

        String ingredientName = faker.space().galaxy();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientName, 200);

        burger.addIngredient(ingredient);

        float price = burger.getPrice();
        String expected = String.format("(==== %s ====)", bunName) + "\n" + "= filling " + ingredientName + " =\n" + String.format("(==== %s ====)", bunName) + "\n" + "\n" + String.format("Price: %,6f", price) + "\n";

        assertEquals("The receipt is not correctly", expected, burger.getReceipt().replaceAll("\r", ""));
    }
}
