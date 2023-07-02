package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerTest {
    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredient1Type;

    private final String ingredient1Name;
    private final float ingredient1Price;


    private final String expected;

    public BurgerTest(String bunName, float bunPrice, IngredientType ingredient1Type,
                      String ingredient1Name, float ingredient1Price, String expected) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredient1Name = ingredient1Name;
        this.ingredient1Type = ingredient1Type;
        this.ingredient1Price = ingredient1Price;
        this.expected = expected;
    }

    //solved the issue with string delimiters by removing them...
    @Parameterized.Parameters
    public static Object[][] getBurgerPrinted() {
        return new Object[][]{
                {"bun", 1, IngredientType.SAUCE, "sauce", 2, "(==== bun ====)\r\n" +
                        "= sauce sauce =\r\n" +
                        "(==== bun ====)\r\n" +
                        "\r\n" +
                        "Price: 4.000000\r\n"},
                {"bun", 1, IngredientType.FILLING, "filling", 1, "(==== bun ====)\r\n" +
                        "= filling filling =\r\n" +
                        "(==== bun ====)\r\n" +
                        "\r\n" +
                        "Price: 3.000000\r\n"}
        };

    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        Bun expected = new Bun("name", 1);
        burger.setBuns(expected);
        Assert.assertEquals(expected, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        Ingredient expectedIngredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        expected.add(expectedIngredient);
        burger.addIngredient(expectedIngredient);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 1);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "name2", 2);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));

    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 3;
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredient.getPrice()).thenReturn(1F);
        Assert.assertEquals(expected, burger.getPrice(), 0.0);

    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredient1Type);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(ingredient.getName()).thenReturn(ingredient1Name);
        Assert.assertEquals(expected.replaceAll("\n|\r\n", " "), burger.getReceipt().replaceAll("\n|\r\n", " "));
    }
}