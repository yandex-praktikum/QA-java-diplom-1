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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)


public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients);
        //assertEquals("Неправильное количество ингридиентов",0,burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        int expected = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size() - 1);
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Мясная котлета", 99));
        burger.addIngredient(new Ingredient(SAUCE, "Кетчуп", 52));
        burger.moveIngredient(0, 1);
        assertEquals("Мясная котлета", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1.00f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(1.00f);
        float actual = burger.getPrice();
        float expected = 3.00f;
        assertEquals(expected, actual, 0);
    }


    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredientSauce = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(55.00f);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("Кетчуп");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(52.00f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Мясная котлета");
        Mockito.when(ingredient.getPrice()).thenReturn(99.00f);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (var ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(receipt.toString(), burger.getReceipt());

    }


}
