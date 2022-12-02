import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class BurgerTest extends DataTest {
    Burger burger;
    private final String bunName = "Флюоресцентная булка R2-D3";
    private final float bunPrice = 988;

    @Before
    public void init() {
        bun = new Bun(bunName, bunPrice);
        burger = new Burger();
        burger.setBuns(bun);

        theFirstIngredient = new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988);
        theSecondIngredient = new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15);
    }
    @Test
    public void putOneIngredient() {
        burger.addIngredient(theFirstIngredient);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void putTwoIngredients() {
        burger.addIngredient(theFirstIngredient);
        burger.addIngredient(theSecondIngredient);

        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(theFirstIngredient);
        burger.addIngredient(theSecondIngredient);

        assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(theSecondIngredient.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(theFirstIngredient);
        burger.addIngredient(theSecondIngredient);

        assertEquals(theFirstIngredient.getName(), burger.ingredients.get(0).getName());
        burger.moveIngredient(0, 1);
        assertEquals(theFirstIngredient.getName(), burger.ingredients.get(1).getName());
    }

   @Test
    public void getPrice() {
        burger.addIngredient(theFirstIngredient);
        burger.addIngredient(theSecondIngredient);
        float expectedPrice = theFirstIngredient.getPrice() + theSecondIngredient.getPrice() + bunPrice * 2;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {

        burger.addIngredient(theFirstIngredient);
        burger.addIngredient(theSecondIngredient);

        String result = "(==== " + bunName + " ====)\r\n" +
                "= filling " + burger.ingredients.get(0).getName() + " =\r\n" +
                "= sauce " + burger.ingredients.get(1).getName() + " =\r\n" +
                "(==== " + bunName + " ====)\r\n" +
                "\r\n" +
                "Price: " + String.format("%.6f", burger.getPrice()) + "\r\n";
        assertEquals(result, burger.getReceipt());
    }
}