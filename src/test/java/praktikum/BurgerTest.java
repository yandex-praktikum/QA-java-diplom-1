package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingr1;
    @Mock
    Ingredient ingr2;


    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingr1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingr1);
        burger.addIngredient(ingr2);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingr1);
        burger.addIngredient(ingr2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingr2,burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingr1);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingr1.getPrice()).thenReturn(10f);
        Assert.assertEquals(20.0, burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingr1);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingr1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingr1.getName()).thenReturn("Говяжий метеорит");
        System.out.println(burger.getReceipt());
        Assert.assertEquals(String.format("(==== Краторная булка N-200i ====)%n" +
                "= filling Говяжий метеорит =%n" +
                "(==== Краторная булка N-200i ====)%n" +
                "%nPrice: 0,000000%n"), burger.getReceipt());
    }
}
