import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger;

    @Before
    public void setUp() {

        burger = new Burger();

    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertTrue("Ожидаемый результат не соответствует фактическому", burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse("Ожидаемый результат не соответствует фактическому", burger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", ingredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = 250.0F;
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedPrice, actualPrice, 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String bunName = "Булочка";
        IngredientType ingredientType = IngredientType.valueOf("SAUCE");
        String ingredientName = "Сыр";
        float expectedPrice = 200f;
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(100f);

        StringBuilder tmpReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));
        tmpReceipt.append(String.format("(==== %s ====)%n", bunName));
        tmpReceipt.append(String.format("%nPrice: %f%n", expectedPrice));
        String expectedReceipt = tmpReceipt.toString();

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedReceipt, actualReceipt);

    }


}