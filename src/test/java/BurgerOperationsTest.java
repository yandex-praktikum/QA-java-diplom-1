import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerOperationsTest {
    static Faker faker = new Faker();
    public Burger burger = new Burger();
    public Bun bun = new Bun(faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    public Ingredient ingredient1 = new Ingredient(SAUCE, faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    public Ingredient ingredient2 = new Ingredient(FILLING, faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    public Ingredient ingredient3 = new Ingredient(FILLING, faker.food().ingredient(), (float) faker.number().randomDouble(2,1, 1000));
    @Before
    public void setUp() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeAllIngredientsTest() {
        int size = burger.ingredients.size();
        for (int i = 0; i < size; i++) {
            burger.removeIngredient(0);
        }
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(burger.ingredients.indexOf(ingredient2));

        Assert.assertTrue(burger.ingredients.contains(ingredient1));
        Assert.assertTrue(burger.ingredients.contains(ingredient3));

        Assert.assertFalse(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0,1);
        Assert.assertEquals(burger.ingredients.get(1), ingredient1);
        Assert.assertEquals(burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void returnPriceTest() {
        float price = bun.getPrice()*2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();
        Assert.assertEquals(burger.getPrice(), price, 0.00001);
    }

    @Test
    public void returnReceiptTest() {
        String text = String.format("(==== %s ====)\r\n= %s %s =\r\n= %s %s =\r\n= %s %s =\r\n" +
                        "(==== %s ====)\r\n\r\nPrice: %f\r\n",
                bun.getName(),
                ingredient1.getType().toString().toLowerCase(),
                ingredient1.getName(),
                ingredient2.getType().toString().toLowerCase(),
                ingredient2.getName(),
                ingredient3.getType().toString().toLowerCase(),
                ingredient3.getName(),
                bun.getName(),
                burger.getPrice());
        Assert.assertEquals(burger.getReceipt(), text);
    }

}