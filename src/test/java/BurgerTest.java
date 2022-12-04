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
import static org.hamcrest.Matchers.equalTo;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;



    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertThat("In class Burger setBuns method set incorrect value", burger.bun, equalTo(bun));
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertThat("In class Burger addIngredient method does not add an element in ArrayList",
                burger.ingredients.contains(ingredient), equalTo(true));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertThat("In class Burger removeIngredient method does not delete element in ArrayList", burger.ingredients.isEmpty(), equalTo(true));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertThat("In class Burger moveIngredient method moves incorrectly element in ArrayList", burger.ingredients.get(0), equalTo(ingredient2));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        float actual = burger.getPrice();
        assertThat("In class Burger getPrice method returns incorrect value", actual, equalTo(30f));
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sausage", 300);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\n= sauce sausage =\n(==== black bun ====)\n\nPrice: 500,000000\n";
        assertThat("In class Burger getReceipt method returns incorrect value", actual, equalTo(expected));
    }
}