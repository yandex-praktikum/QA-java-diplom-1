package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;


    @Test
    public void IngredientsCanBeAdded() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assertions.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void IngredientsCanBeRemoved() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assertions.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void IngredientsCanBeMoved() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("cutlet", burger.ingredients.get(1).name);
    }

    @Test
    public void getBurgerPriceTest() {
        Burger burger = new Burger();
        float price = 100;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assertions.assertEquals(price * 2 + price, burger.getPrice());
    }

    @Test
    public void burgerCanGetReceipt(){
        Burger burger = new Burger();
        burger.setBuns(new Bun("Датская булочка", 150));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"Шоколадный", 20));
        String expected = String.format("(==== Датская булочка ====)\n= sauce Шоколадный =\n(==== Датская булочка ====)\n\nPrice: 320.000000\n", burger.getReceipt().toString());
        String actualReceipt = burger.getReceipt();
        System.out.println(burger.getReceipt());

        assertEquals(expected, actualReceipt);

    }

}