package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BurgerTest {

    @Mock
    private Bun bun;
    private Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("name");
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Assert.assertEquals("name", burger.bun.getName());
        Assert.assertEquals(10f, burger.bun.getPrice(), 0.0);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name", 10f));
        Assert.assertEquals(IngredientType.FILLING, burger.ingredients.get(0).getType());
        Assert.assertEquals("name", burger.ingredients.get(0).getName());
        Assert.assertEquals(10f, burger.ingredients.get(0).getPrice(), 0.0);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name", 10f));
        burger.removeIngredient(0);
        Assert.assertEquals(IngredientType.FILLING, burger.ingredients.get(0).getType());
        Assert.assertEquals("name", burger.ingredients.get(0).getName());
        Assert.assertEquals(10f, burger.ingredients.get(0).getPrice(), 0.0);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "name", 10f));
        burger.moveIngredient(1, 0);
        Assert.assertEquals(IngredientType.FILLING, burger.ingredients.get(0).getType());
        Assert.assertEquals("name", burger.ingredients.get(0).getName());
        Assert.assertEquals(10f, burger.ingredients.get(0).getPrice(), 0.0);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(new Bun("bun", 30f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 10f));
        Assert.assertEquals(90f, burger.getPrice(), 0.00001);
    }

    @Test
    public void getPriceNoBunTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 10f));
        Assert.assertEquals(30f, burger.getPrice(), 0.00001);
    }

    @Test
    public void getPriceNoIngredientTest() {
        burger.setBuns(new Bun("bun", 30f));
        Assert.assertEquals(60f, burger.getPrice(), 0.00001);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(new Bun("bun", 30f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 10f));
        String expected = "(==== bun ====)\r\n= sauce sauce =\r\n= filling filling =\r\n(==== bun ====)\r\n\r\nPrice: 90,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void getReceiptNoBunTest() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 10f));
        String expected = "= sauce sauce =\r\n= filling filling =\r\n\r\nPrice: 30,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void getReceiptNoIngredientTest() {
        burger.setBuns(new Bun("bun", 30f));
        String expected = "(==== bun ====)\r\n(==== bun ====)\r\n\r\nPrice: 60,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }

}
