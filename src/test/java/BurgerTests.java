import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Список ингридиентов должын содержать 1 элемент",
                1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Список ингридиентов должен быть пустой",
                0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(secondIngredient);
        expected.add(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(50.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(20.0F);
        Assert.assertEquals("Бургер должен стоить 120 рублей",
                120.0,burger.getPrice(),0.0);
    }


}
