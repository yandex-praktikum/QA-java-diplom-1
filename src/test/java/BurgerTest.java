import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private Ingredient ingredient;;
    private Bun bun;
    private float bunPrice = 5.00f;
    private String bunName = "tastyBun";
    private String ingredientName = "tastyOnion";
    private float ingredientPrice = 10.00f;
    private IngredientType type = FILLING;

    @Mock
    Bun mockedBun;
    @Mock
    Ingredient mockedIngredient;
    @Mock
    Ingredient mockedAnotherIngredient;

    @Before
    public void setUp() throws Exception {
        burger = new Burger();
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void setBunsShouldAddBun() {
        burger.setBuns(mockedBun);
        assertEquals(mockedBun, burger.bun);
    }

    @Test
    public void addIngredientShouldAddIngredient() {
        burger.addIngredient(mockedIngredient);
        MatcherAssert.assertThat(burger.ingredients, notNullValue());
    }

    @Test
    public void removeIngredientShouldDeleteIngredient() {
        burger.ingredients.add(0, mockedIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientShouldReplaceIt() {
        burger.ingredients.add(0, mockedIngredient);
        burger.ingredients.add(1, mockedAnotherIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(mockedAnotherIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceShouldReturnTotalPrice() {
        burger.setBuns(mockedBun);
        Mockito.when(mockedBun.getPrice()).thenReturn(5f);
        burger.addIngredient(mockedIngredient);
        Mockito.when(mockedIngredient.getPrice()).thenReturn(10f);
        Assert.assertEquals(20f, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceipts() {
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);
        Mockito.when(mockedBun.getName()).thenReturn(bunName);
        Mockito.when(mockedIngredient.getType()).thenReturn(type);
        Mockito.when(mockedIngredient.getName()).thenReturn(ingredientName);
        MatcherAssert.assertThat(burger.getReceipt(), notNullValue());
    }
}