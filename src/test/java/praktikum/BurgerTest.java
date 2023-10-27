package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun blackBun;
    @Mock
    Ingredient sausageFilling;
    @Mock
    Ingredient sourCreamSauce;


    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        System.out.println(blackBun);
        assertThat("No bun added to burger", burger.bun, is(notNullValue()));
    }

    @Test
    public void checkAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(sausageFilling);
        assertTrue("No ingredient added to burger", burger.ingredients.contains(sausageFilling));
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(sourCreamSauce);
        burger.removeIngredient(0);
        assertTrue("Ingredient not removed!", burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
//        Burger burger = new Burger();
//        burger.addIngredient(sausageFilling);
//        burger.addIngredient(sourCreamSauce);
//        List<Ingredient> ingredient = new ArrayList<>();
//        ingredient.add(sausageFilling);
//        ingredient.add(sourCreamSauce);
//        burger.moveIngredient(0, 1);
//        Assert.assertEquals("Ingredient not moved!", burger.ingredients, ingredient);

        Burger burger = new Burger();
        burger.addIngredient(sourCreamSauce);
        burger.addIngredient(sausageFilling);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(sausageFilling);
        ingredient.add(sourCreamSauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ingredient not moved!", burger.ingredients, ingredient);

    }

    @Test
    public void checkGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        burger.addIngredient(sourCreamSauce);
        burger.addIngredient(sausageFilling);
        Mockito.when(blackBun.getPrice()).thenReturn(100F);
        Mockito.when(sourCreamSauce.getPrice()).thenReturn(200F);
        Mockito.when(sausageFilling.getPrice()).thenReturn(300F);
        Assert.assertEquals("Price is incorrect", burger.getPrice(), 700, 0);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        burger.addIngredient(sausageFilling);
        burger.addIngredient(sourCreamSauce);
        Mockito.when(blackBun.getName()).thenReturn("black bun");
        Mockito.when(sourCreamSauce.getName()).thenReturn("sour cream");
        Mockito.when(sausageFilling.getName()).thenReturn("sausage");
        Mockito.when(sourCreamSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sausageFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(blackBun.getPrice()).thenReturn(100f);
        Mockito.when(sourCreamSauce.getPrice()).thenReturn(200f);
        Mockito.when(sausageFilling.getPrice()).thenReturn(300f);
        String newGetReceipt = "(==== black bun ====)\n" +
                "= filling sausage =\n" +
                "= sauce sour cream =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 700,000000" + "\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals("Receipt have incorrect information about burger!", newGetReceipt.replace("\r\n", "\n"), actualReceipt.replace("\r\n", "\n"));


    }
}