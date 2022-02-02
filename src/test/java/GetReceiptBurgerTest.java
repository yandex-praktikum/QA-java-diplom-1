import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class GetReceiptBurgerTest {

    @Test
    public void canGetBurgerReceipt() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Имбирный",3F);
        Bun bun = new Bun("С кунжутом", 1F);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);


        String expectedReceipt = "(==== С кунжутом ====)\n" +
                "= sauce Имбирный =\n" +
                "(==== С кунжутом ====)\n" +
                "\n" +
                "Price: 5,000000\n";
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}