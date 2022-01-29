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

        System.out.println(burger.getReceipt());

        String expectedReceipt = String.format(("(==== " + bun.getName() + " ====)%n= " + ingredient.getType().toString().toLowerCase() + " " + ingredient.getName() + " =%n(==== " + bun.getName() + " ====)%n%nPrice: %f%n"), burger.getPrice());
        System.out.println(expectedReceipt);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}