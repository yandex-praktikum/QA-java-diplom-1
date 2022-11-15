import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.containsString;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    String nameOfBun = "bun";
    String nameOfIngredient = "tomato";
    String typeOfIngredient = "sauce";

    @Test
    public void setBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertTrue(burger.ingredients.size() > 0);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient1.getPrice()).thenReturn(100F);
        Mockito.when(ingredient2.getPrice()).thenReturn(100F);
        Assert.assertEquals(400F, burger.getPrice(), 0);
    }
    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getName()).thenReturn(nameOfBun);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn(nameOfIngredient);
        MatcherAssert.assertThat(burger.getReceipt(), containsString(nameOfBun));
        MatcherAssert.assertThat(burger.getReceipt(), containsString(nameOfIngredient));
        MatcherAssert.assertThat(burger.getReceipt(), containsString(typeOfIngredient));
    }
}
