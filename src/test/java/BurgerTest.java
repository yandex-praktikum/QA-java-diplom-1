import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredient2;
    @Mock
    private Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void getAddBunValue(){
        burger.setBuns(bun);
        assertEquals(bun,burger.bun);
    }

    @Test
    public void getAddIngredientValue() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void getRemoveIngredientValue() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getMoveIngredientValue() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getGetPriceValue() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient.getPrice()).thenReturn(100.0f);
       burger.setBuns(bun);
       burger.addIngredient(ingredient);
       assertThat(burger.getPrice(), is(300.0f));
    }

    @Test
    public void getGetReceiptValue() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(bun.getName()).thenReturn("black bun");
        when(ingredient.getPrice()).thenReturn(100.0f);
        when(ingredient.getName()).thenReturn("cutlet");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getPrice()).thenReturn(200.0f);
        when(ingredient2.getName()).thenReturn("dinosaur");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient3.getPrice()).thenReturn(200.0f);
        when(ingredient3.getName()).thenReturn("sour cream");
        when(ingredient3.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== black bun ====)\n" +
                "= sauce sour cream =\n" +
                "= filling cutlet =\n" +
                "= filling dinosaur =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 700,000000\n";
        System.out.println(burger.getReceipt());
        assertEquals(expectedReceipt, burger.getReceipt());

    }

}
