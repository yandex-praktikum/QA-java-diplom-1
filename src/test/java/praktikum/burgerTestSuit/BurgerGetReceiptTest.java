package praktikum.burgerTestSuit;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class BurgerGetReceiptTest {
    @Test
    public void burgerGetReceiptTest() {
        Burger testBurger = new Burger();
        Ingredient testIngredient = new Ingredient(IngredientType.FILLING, "Мясо кротокрыска", 6F);
        Bun testBun = new Bun("Бритвозлачная", 3F);
        testBurger.addIngredient(testIngredient);
        testBurger.setBuns(testBun);
        System.out.println(testBurger.getReceipt());
        String expectedReceipt = String.format(("(==== " +
                                               testBun.getName() +
                                               " ====)%n= " +
                                               testIngredient.getType().toString().toLowerCase() +
                                               " " +
                                               testIngredient.getName() +
                                               " =%n(==== " +
                                               testBun.getName() +
                                               " ====)%n%nPrice: %f%n"),
                                               testBurger.getPrice());
                System.out.println(expectedReceipt);
        Assert.assertEquals(expectedReceipt, testBurger.getReceipt());
    }
}
