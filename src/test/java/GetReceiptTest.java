import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class GetReceiptTest {
    Bun bun = new Bun("burger", 10.00F);
    Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "ketchup", 20.00F);
    Ingredient mustard = new Ingredient(IngredientType.SAUCE, "mustard", 30.00F);
    Ingredient mayonnaise = new Ingredient(IngredientType.SAUCE, "mayonnaise", 40.00F);
    String expected1 = "(==== burger ====)\r\n" +
            "= sauce ketchup =\r\n" +
            "= sauce mustard =\r\n" +
            "= sauce mayonnaise =\r\n" +
            "(==== burger ====)\r\n" +
            "\r\n" +
            "Price: 110,000000\r\n";
    String expected2 = "(==== burger ====)\r\n" +
            "= sauce ketchup =\r\n" +
            "= sauce mayonnaise =\r\n" +
            "(==== burger ====)\r\n" +
            "\r\n" +
            "Price: 80,000000\r\n";
    String expected3 = "(==== burger ====)\r\n" +
            "= sauce ketchup =\r\n" +
            "= sauce mayonnaise =\r\n" +
            "= sauce mustard =\r\n" +
            "(==== burger ====)\r\n" +
            "\r\n" +
            "Price: 110,000000\r\n";

    @Test
    public void ReceiptWithThreeIngredientsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(mustard);
        burger.addIngredient(mayonnaise);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expected1, actualReceipt);
    }

    @Test
    public void ReceiptWithTwoIngredientsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(mustard);
        burger.addIngredient(mayonnaise);
        burger.removeIngredient(1);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expected2, actualReceipt);
    }

    @Test
    public void ReceiptWithThreeSwapIngredientsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(mustard);
        burger.addIngredient(mayonnaise);
        burger.moveIngredient(1, 2);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expected3, actualReceipt);
    }
}
