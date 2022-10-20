import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("black bun", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));

        float price = burger.getPrice();
        Assert.assertEquals(price, 400, 0.0001);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));

        String receipt = burger.getReceipt();
        Assert.assertEquals(receipt, "(==== white bun ====)\r\n= sauce sour cream =\r\n= filling dinosaur =\r\n(==== white bun ====)\r\n\r\nPrice: 800,000000\r\n");
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.removeIngredient(1);

        String receipt = burger.getReceipt();
        Assert.assertEquals(receipt, "(==== white bun ====)\r\n= sauce sour cream =\r\n(==== white bun ====)\r\n\r\nPrice: 600,000000\r\n");
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.moveIngredient(1, 0);

        String receipt = burger.getReceipt();
        Assert.assertEquals(receipt, "(==== white bun ====)\r\n= filling dinosaur =\r\n= sauce sour cream =\r\n(==== white bun ====)\r\n\r\nPrice: 800,000000\r\n");
    }
}
