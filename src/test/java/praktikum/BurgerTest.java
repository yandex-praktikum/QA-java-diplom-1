package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burger;

    @Test
    public void setBunsAnyTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("hot sauce", 100));
        Assert.assertEquals(200, burger.getPrice(), 1);
    }

    @Test
    public void addIngredientAnyTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void removeIngredientAnyIntTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.removeIngredient(0);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void moveIngredientAnyIntTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.moveIngredient(0, 0);
        Assert.assertNotNull(burger.ingredients);
        //Mockito.verify(burger).removeIngredient(Mockito.anyInt());
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("hot sauce", 100));
        float actual = burger.getPrice();
        Assert.assertEquals(200, actual, 1);

    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("hot sauce", 100));
        System.out.println(burger.getReceipt());
        Assert.assertNotNull(burger.ingredients);

    }
}
