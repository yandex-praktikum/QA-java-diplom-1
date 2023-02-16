import org.testng.Assert;
import org.testng.annotations.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestBurger {
    @Test
    public void getPriceTest() {
        Bun bun = new Bun ("Bun", 120);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Red", 50);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Cheese", 10);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expectedPrice = bun.price*2 + sauce.price + filling.price;
        float actualPrice = burger.getPrice();
        System.out.println(burger.getReceipt());
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun ("Bun", 120);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Red", 50);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Cheese", 10);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        String expectedString = "(==== Bun ====)\n= sauce Red =\n= filling Cheese =\n(==== Bun ====)\n\nPrice: 300,000000\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedString, actualReceipt);
    }

    @Test
    public void addIngredientTest() {
        Bun bun = new Bun ("Bun", 120);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Red", 50);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        String expectedString = "(==== Bun ====)\n= sauce Red =\n(==== Bun ====)\n\nPrice: 290,000000\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedString, actualReceipt);
    }

    @Test
    public void removeIngredientTest() {
        Bun bun = new Bun ("Bun", 120);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Red", 50);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        String expectedString = "(==== Bun ====)\n(==== Bun ====)\n\nPrice: 240,000000\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedString, actualReceipt);
    }

    @Test
    public void moveIngredientTest() {
        Bun bun = new Bun ("Bun", 120);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Red", 50);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Cheese", 10);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        String expectedString = "(==== Bun ====)\n= filling Cheese =\n= sauce Red =\n(==== Bun ====)\n\nPrice: 300,000000\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedString, actualReceipt);
    }

}