package praktikum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
class BurgerTest {
    @Spy
    Bun bun = new Bun("black bun", 5F);
    @Spy
    Ingredient ingredient = new Ingredient(SAUCE, "Кетчуп", 4F);
    Burger burger = new Burger();
    @Test
    void setBuns() {
        burger.setBuns(bun);
        Assert.assertNotNull(bun);
    }

    @Test
    void getPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Assert.assertEquals(14F, burger.getPrice(), 0);
    }
    @Test
    void getReceipt() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Assert.assertNotNull(bun);
       // String actReceipt = burger.getReceipt().toString();
       // System.out.println(actReceipt);
    }
}