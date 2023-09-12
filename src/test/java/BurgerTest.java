import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class BurgerTest extends TestUtils {
    Database database = new Database();

    @Test
    public void addIngredient(){
        List<Bun> availableBuns = database.availableBuns();
        List<Ingredient> availableIngredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(availableBuns.get(1));
        float priceWithoutAddingIngredient = burger.getPrice();
        burger.addIngredient(availableIngredients.get(2));
        float priceWithAddingIngredient = burger.getPrice();
        assertNotEquals(priceWithAddingIngredient,priceWithoutAddingIngredient,0);
    }
    @Test
    public void removeIngredient() {
        Burger burger = TestUtils.createBurger();
        float actualPrice = burger.getPrice();//общая цена 800
        burger.removeIngredient(1);//цена 200
        float actualPriceWithoutIngredient = burger.getPrice();//цена без одного ингридиента
        assertNotEquals(actualPrice,actualPriceWithoutIngredient,0);
    }

    @Test
    public void moveIngredient() {
        Burger burger = TestUtils.createBurger();
        burger.moveIngredient(0,1);
        String actualReceipt = burger.getReceipt();
        burger.moveIngredient(1,0);
        String expectedReceipt = burger.getReceipt();
        assertNotEquals(expectedReceipt,actualReceipt);
    }

    @Test
    public void getPrice() {
        Burger burger = TestUtils.createBurger();
        assertEquals(400.0,burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        Burger burger = TestUtils.createBurger();
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 400,000000\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
