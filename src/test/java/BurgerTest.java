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
    private Ingredient ingredient;
    private Burger burger;
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();

        burger.setBuns(bun);

        ingredient = new Ingredient(IngredientType.FILLING, "Тест1", 5);
        burger.addIngredient(ingredient);
    }

    @Test
    public void setBuns() {
        Mockito.when(burger.bun.getName()).thenReturn("Тест2");
        Assert.assertEquals("Элемент не добавлен", "Тест2", burger.bun.getName());
    }

    @Test
    public void checkAddIngredient() {
        Assert.assertFalse("Элемент не добавлен", burger.ingredients.isEmpty());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.removeIngredient(0);

        Assert.assertTrue("Элемент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        ingredient = new Ingredient(IngredientType.SAUCE, "тест2", 11);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Элемент не перемещен", "тест2", burger.ingredients.get(0).name);
    }

    @Test
    public void getReceipt() {
        Mockito.when(burger.bun.getName()).thenReturn("булочка");

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", burger.bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", burger.bun.getName()));
        Mockito.when(burger.bun.getPrice()).thenReturn(50);
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(burger.getReceipt(), receipt.toString());
    }
}