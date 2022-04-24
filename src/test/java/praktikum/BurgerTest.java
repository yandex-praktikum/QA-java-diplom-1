package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class BurgerTest {
    String name;
    float price;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(10);
        price = nextFloat();
    }

    @Test
    public void methodSetBunsShouldSetBun() {
        Burger burger = new Burger();
        Bun bun = new Bun(name, price);

        burger.setBuns(bun);

        Assert.assertEquals("Wrong value in the field bun", bun, burger.bun);
    }

    @Test
    public void methodAddIngredientShouldAddElementInList() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        burger.addIngredient(ingredient);

        Assert.assertEquals("Ingredient do not added in List", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void methodRemoveIngredientShouldRemoveElementInList() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals("Ingredient was not removed from List", 0, burger.ingredients.size());
    }

    @Test
    public void methodMoveIngredientShouldMoveElementInList() {
        String name1 = RandomStringUtils.randomAlphabetic(10);
        float price1 = nextFloat();

        Burger burger = new Burger();

        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, name, price);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, name1, price1);

        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(1, 0);

        Assert.assertEquals("Ingredients was not moved in List", ingredient1, burger.ingredients.get(0));
        Assert.assertEquals("Ingredients was not moved in List", ingredient0, burger.ingredients.get(1));
    }

    @Test
    public void methodGetReceiptShouldReturnString() {
        String nameIngredient = RandomStringUtils.randomAlphabetic(10);
        float priceIngredient = nextFloat();

        Bun bun = new Bun(name, price);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, nameIngredient, priceIngredient);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float burgerPrice = burger.getPrice();


        String expectedReceipt =  String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", name,
                IngredientType.FILLING.toString().toLowerCase(), nameIngredient, name, burgerPrice);

        Assert.assertEquals("Printed Receipt does not match the expected", expectedReceipt, burger.getReceipt());
    }
}
