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


import static praktikum.IngredientType.FILLING;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Before
    public void testSetup() {
        burger = new Burger();
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент не был удален", 0, burger.ingredients.size());
    }

    @Test
    public void priceBurgerTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Цена бургера некорректная", 400f, burger.getPrice(), 0);
    }

    @Test
    public void receiptBurgerTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("булочка");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("котлета");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals("Рецепт бургера некорректный", expected, burger.getReceipt());
        System.out.println(burger.getReceipt());
    }


}
