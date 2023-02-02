package praktikum.burgerTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BurgerTest {

    private Bun bun;
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }


    @Test
    public void setBunValidValuesReturnsValidBun() {
        bun = new Bun("black bun", 100F);
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }

    @Test
    public void setBunNullReturnsNullBun() {
        //следует ограничить возможность устанавливать булки с null
        burger.setBuns(bun);
        assertThat("Должен видеть объект null", bun, is(nullValue()));

    }

    @Test(expected = NullPointerException.class)
    public void getPriceNoBunShowsException() {
        burger.getPrice();
    }

    @Test
    public void shouldNotSeePriceWithoutBun1() {
        float bunPrice = 100F; //todo подумать над наименованиями
        float actualPrice = 200F;
        bun = new Bun("some name", bunPrice);
        burger.setBuns(bun);

        assertThat("Should see price with bun", burger.getPrice(), is(actualPrice));

    }

    @Test
    public void shouldNotSeePriceWithoutBun2() {
        float bunPrice = 100F; //todo подумать над наименованиями
        float actualPrice = 200F;

        bun = new Bun("some name", bunPrice);
        burger.setBuns(bun);

        assertThat("Should see price with bun", burger.getPrice(), is(actualPrice));

    }


    @Test
    public void addIngredient() {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name", 100));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name", 100));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "name", 100));
    }

    @Test
    public void getPrice() {
        bun = new Bun("Name1", 100F);

        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "name", 50));
        assertEquals(250, burger.getPrice());

    }

    @Test
    public void getReceipt() {
    }
}