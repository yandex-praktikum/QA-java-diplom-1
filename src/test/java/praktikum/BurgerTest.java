package praktikum;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    static Faker faker = new Faker();
    private final Float price = Float.valueOf(RandomStringUtils.randomNumeric(3));
    private final Float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;
    private String name;
    @Mock
    Bun bun = new Bun(name, price);
    private IngredientType type;

    @Test
    public void testAddIngredientAddsOneIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientRemovesOneIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(type, name, price);
        Ingredient ingredient2 = new Ingredient(type, name, price);
        Ingredient ingredient3 = new Ingredient(type, name, price);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(2, 1);
        Assert.assertEquals(1, burger.ingredients.indexOf(ingredient3));
    }

    @Test
    public void testGetPriceForBunsDoublePrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Assert.assertEquals(price * 2, burger.getPrice(), 0.0);
    }

    @Test
    public void testGetPriceForIngredientSumIngredientPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Assert.assertEquals(price * 2 + ingredientPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        String bunName = RandomStringUtils.randomAlphabetic(5);
        double price = (float) faker.number().randomDouble(6, 100, 500);
        String ingredientName = RandomStringUtils.randomAlphabetic(5);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn((float) price);
        String expectedResult = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %.6f%n", bunName, IngredientType.SAUCE.toString().toLowerCase(), ingredientName, IngredientType.FILLING.toString().toLowerCase(), ingredientName, bunName, price);
        Assert.assertEquals(expectedResult, burger.getReceipt());
    }
}