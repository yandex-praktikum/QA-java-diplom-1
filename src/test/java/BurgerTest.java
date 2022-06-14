import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class BurgerTest {
    String bun;
    String sause;
    String filling;
    float fillingPrice;
    float totalPrice;

    Burger burger;

    public BurgerTest(String bun, float bunPrice, String sause, float sausePrice, String filling, float fillingPrice, float totalPrice) {
        this.bun = bun;
        this.sause = sause;
        this.filling = filling;
        this.fillingPrice = fillingPrice;
        this.totalPrice = totalPrice;

        burger = new Burger();
        burger.setBuns(new Bun(bun, bunPrice));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, sause, sausePrice));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, filling, fillingPrice));
    }

    @Parameterized.Parameters
    public static Object[] burgerType() {
        return new Object[][]{
                {"black bun", 100, "hot sauce", 50, "cutlet", 100, 350},
                {"white bun", 100, "sour cream", 50, "dinosaur", 200, 450},
                {"red bun", 100, "chili sauce", 50, "sausage", 300, 550}
        };
    }

    @Test
    public void checkReceiptTest() {

        assertEquals(burger.getReceipt(), String.format("(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n", bun, sause, filling, bun, totalPrice));

    }

    @Test
    public void checkMovingIngredient() {
        String additionalFillingName = "cucumber";
        float additionalFillingPrice = 70;
        burger.addIngredient(new Ingredient(IngredientType.FILLING, additionalFillingName, additionalFillingPrice));
        burger.moveIngredient(2, 1);
        assertEquals(burger.getReceipt(), String.format("(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n", bun, sause, additionalFillingName, filling, bun, totalPrice + additionalFillingPrice));
    }

    @Test
    public void checkRemoveIngredient() {
        String additionalFillingName = "cucumber";
        float additionalFillingPrice = 70;
        burger.addIngredient(new Ingredient(IngredientType.FILLING, additionalFillingName, additionalFillingPrice));
        burger.removeIngredient(1);
        assertEquals(burger.getReceipt(), String.format("(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n", bun, sause, additionalFillingName, bun, totalPrice + additionalFillingPrice - fillingPrice));
    }
}
