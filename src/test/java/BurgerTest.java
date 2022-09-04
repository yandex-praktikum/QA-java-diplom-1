import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientFirst;
    @Mock
    Ingredient ingredientSecond;



    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        assertThat(burger.ingredients.contains(ingredientFirst), equalTo(true));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(burger.ingredients.indexOf(ingredientFirst));
        assertThat(burger.ingredients.contains(ingredientFirst), equalTo(false));
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(burger.ingredients.indexOf(ingredientFirst), 1);
        assertThat(burger.ingredients.indexOf(ingredientFirst), equalTo(1));
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        Mockito.when(bun.getName()).thenReturn("Bun name");
        Mockito.when(ingredientFirst.getName()).thenReturn("Some ingredient");
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(10.0F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(10.0F);
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Bun name"));
        expectedReceipt.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), "Some ingredient"));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(burger.getReceipt(),expectedReceipt.toString());
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        Mockito.when(bun.getPrice()).thenReturn(10.0F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(10.0F);
        assertThat(burger.getPrice(), equalTo(30F));
    }
}


