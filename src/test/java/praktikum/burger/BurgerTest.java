package praktikum.burger;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

@Epic(value = "Stellar Burgers")
@Feature(value = "Burger Receipt")
@Story(value = "Burger Test")
public class BurgerTest {
    private String name;
    private float price;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(10);
        price = nextFloat();
    }

    @Test
    @DisplayName("Set bun to a burger")
    @Description("Create the new burger and then try set bun to a burger")
    public void methodSetBunsShouldSetBun() {
        Burger burger = new Burger();
        Bun bun = new Bun(name, price);

        burger.setBuns(bun);

        Assert.assertEquals("Wrong value in the field bun", bun, burger.bun);
    }

    @Test
    @DisplayName("Add ingredient to a burger")
    @Description("Create the new burger and then try add random ingredient to a burger")
    public void methodAddIngredientShouldAddElementInList() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        burger.addIngredient(ingredient);

        Assert.assertEquals("Ingredient do not added in List", ingredient, burger.ingredients.get(0));
    }

    @Test
    @DisplayName("Remove ingredient from a burger")
    @Description("Create the new burger, then add random ingredient and try to remove this ingredient from a burger")
    public void methodRemoveIngredientShouldRemoveElementInList() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals("Ingredient was not removed from List", 0, burger.ingredients.size());
    }

    @Test
    @DisplayName("Move ingredients in a burger")
    @Description("Create the new burger, then add two random ingredients and then try to move this ingredients in a burger")
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
    @DisplayName("Getting a burger receipt")
    @Description("Create the new burger then add random bun, ingredient and then try to get a burger receipt")
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
