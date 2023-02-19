package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    //"Количество ингредиентов увеличивается при добавлении".
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    //"Количество ингредиентов уменьшается при удалении"
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    //"Цена подсчитывается корректно"
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expectedPrice = 300F;
        MatcherAssert.assertThat("Цена посчитана неверно", burger.getPrice(), is(expectedPrice));
    }

    @Test
    //"Рецепт строится корректно"
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        String expectedReceipt = "(==== red bun ====)\r\n= filling dinosaur =\r\n(==== red bun ====)\r\n\r\nPrice: 800.000000\r\n";

        assertEquals("Рецепт неверен", expectedReceipt, burger.getReceipt());
    }
}