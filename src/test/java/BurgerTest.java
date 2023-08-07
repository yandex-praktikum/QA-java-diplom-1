import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BurgerTest {

    @Test //проверка возвращения корректного рецепта
    public void getReceiptTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("Cosmo bun", 10);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "beef", 100);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== Cosmo bun ====)\r\n= filling beef =\r\n(==== Cosmo bun ====)\r\n\r\nPrice: 120,000000\r\n";
        assertThat( actual, equalTo(expected));
    }
}
