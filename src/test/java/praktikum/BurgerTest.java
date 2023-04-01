package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;
    @Mock
    Burger burger;

    @Test
    public void setBunsWithNotNullValue() {
        Burger burger =  new Burger();
        burger.setBuns(bun);
        assertThat(burger.bun, notNullValue());
    }
    @Test
    public void setBunsWithCorrectArgument() {
       burger.setBuns(bun);
       Mockito.verify(burger).setBuns(bun);
    }
    @Test
    public void setBunsCallOneTime() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientOneTime() {
        Burger burger =  new Burger();
        burger.addIngredient(ingredient1);
        assertThat(burger.ingredients.size(), is(1));
    }

    @Test
    public void addIngredientFourTimes() {
        Burger burger =  new Burger();
        for(int i = 0; i < 4; i++){
            burger.addIngredient(ingredient2);
        }
        assertThat(burger.ingredients.size(), is(4));
    }

    @Test
    public void removeIngredientWithIndexOne() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertThat(burger.ingredients.size(), is(2));
        burger.removeIngredient(1);
        assertThat(burger.ingredients.size(), is(1));
        Ingredient expected = ingredient1;
        Ingredient actual = burger.ingredients.get(0);
        assertEquals("Проверка ингредиента", expected, actual);
    }

    @Test
    public void moveIngredientWithIndexOneToIndexTwo() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertThat(burger.ingredients.size(), is(3));
        burger.moveIngredient(1, 2);
        Ingredient expected = ingredient2;
        Ingredient actual = burger.ingredients.get(2);
        assertEquals("Проверка ингредиента", expected, actual);
    }

    @Test
    public void getPriceForBurgerWithTwoBunsAndThreeIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Mockito.when(bun.getPrice()).thenReturn(2.99f);
        Mockito.when(ingredient1.getPrice()).thenReturn(1.82f);
        Mockito.when(ingredient2.getPrice()).thenReturn(0.85f);
        Mockito.when(ingredient3.getPrice()).thenReturn(2.15f);
        float expected = 10.8f;
        float actual = burger.getPrice();
        assertEquals("Цена бургера", expected, actual, 0.01);
    }

    @Test
    public void getPriceForEmptyBurger() throws Exception {
        try {
            Burger burger = new Burger();
            float expected = 0;
            float actual = burger.getPrice();
            assertEquals("Цена бургера", expected, actual, 0.01);
        } catch (Exception exception) {
            assertThat(exception.toString(), is("java.lang.NullPointerException"));
        }
    }

    @Test
    public void getReceiptForBurgerWithBunsAndTwoIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("Star M-19");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(ingredient1.getName()).thenReturn("Moon");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient2.getName()).thenReturn("Cheese");
        String expected = "(==== Star M-19 ====)\n" +
                "= sauce Moon =\n" +
                "= filling Cheese =\n" +
                "(==== Star M-19 ====)\n" +
                "\n" +
                "Price: 0,000000" +
                "\n";
        String actual = burger.getReceipt();
        expected.equals(actual);
    }
}