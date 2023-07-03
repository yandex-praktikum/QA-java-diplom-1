import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void init() {
        Database database = new Database();
        burger = new Burger();
        bun = database.availableBuns().get(2);
        burger.setBuns(bun);
        sauce = database.availableIngredients().get(2);
        filling = database.availableIngredients().get(3);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void testPrice(){
        float expectedPrice = 300 * 2 + 300 + 100;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testPriceWithRemoveIngredient() {
        for (int i = burger.ingredients.size(); i >= 1; i--) {
            burger.removeIngredient(i - 1);
        }
        Assert.assertEquals(600, burger.getPrice(), 0);
    }

    @Test
    public void testPriceWithMoveIngredient() {
        for (int i = 0; i < burger.ingredients.size(); i++) {
            burger.moveIngredient(0,1);
        }
        Assert.assertEquals(1000, burger.getPrice(), 0);
    }

    @Test
    public void testBurgerReceipt() {
        String actualReceipt = burger.getReceipt();
        String bunString = String.format("(==== %s ====)%n", bun.getName());
        String sauceString = String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName());
        String fillingString = String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName());
        String priceString = String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(bunString + sauceString + fillingString + bunString + priceString, actualReceipt);
    }
}
