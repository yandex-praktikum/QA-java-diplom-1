import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    IngredientType ingredientType;

    @Mock
    Ingredient ketchup = new Ingredient(ingredientType.SAUCE, "Кенчуп", 99.99F);;

    @Test
    public void addIngredientTest() {
        Ingredient ketchup = new Ingredient(ingredientType.SAUCE, "Кенчуп", 99.99F);
        Burger burger = new Burger();
        burger.addIngredient(ketchup);

        int unexpected = -1;
        int actual = burger.ingredients.indexOf(ketchup);

        assertNotEquals(unexpected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "Кенчуп", 99.99F);
        Burger burger = new Burger();
        burger.addIngredient(ketchup);
        burger.removeIngredient(0);

        int expected = -1;
        int actual = burger.ingredients.indexOf(ketchup);

        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "Кенчуп", 99.99F);
        Ingredient putty = new Ingredient(IngredientType.SAUCE, "Коклета", 9.99F);
        Burger burger = new Burger();
        burger.addIngredient(ketchup);
        burger.addIngredient(putty);
        burger.moveIngredient(1, 0);

        int expected = 0;
        int actual = burger.ingredients.indexOf(putty);

        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Бриош", 10.0F);
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "Кенчуп", 90.0F);
        Ingredient putty = new Ingredient(IngredientType.SAUCE, "Коклета", 20.0F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(putty);

        float expected = 130.0F;
        float actual = burger.getPrice();

        assertEquals(expected, actual, 0.0F);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("Бриош", 10.0F);
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "Кенчуп", 90.0F);
        Ingredient putty = new Ingredient(IngredientType.SAUCE, "Коклета", 20.0F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(putty);

        String expected = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ketchup.getType().toString().toLowerCase(),
                ketchup.getName()) +
                String.format("= %s %s =%n", putty.getType().toString().toLowerCase(),
                        putty.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}
