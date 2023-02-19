import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void checkingSetBunsName(){
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Name");

        String expectedResult = "Name";
        assertEquals(expectedResult, burger.bun.getName());
    }

    @Test
    public void checkingSetBunsPrice(){
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(100500F);

        float expectedResult = 100500F;
        assertEquals(expectedResult, burger.bun.getPrice(),0.0F);
    }

    @Test
    public void checkingAddIngredient(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Космобулка",100500F);

        burger.addIngredient(ingredient);

        Ingredient actualResult = burger.ingredients.get(0);
        assertEquals(ingredient, actualResult);
    }

    @Test
    public void checkingRemoveIngredient(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Космобулка",100500F);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int expectedResult = 0;
        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void checkingMoveIngredient(){
        Ingredient ingredient_1 = new Ingredient(IngredientType.SAUCE,"Космобулка",100500F);
        Ingredient ingredient_2 = new Ingredient(IngredientType.FILLING,"Космомясо",200500F);

        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(0,1);

        assertEquals(ingredient_2, burger.ingredients.get(0));
    }

    @Test
    public void checkingGetPrice(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Космобулка",100500F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100F);

        float expectedResult = 100700F;
        float actualResult = burger.getPrice();
        assertEquals(expectedResult,actualResult,0.0F);
    }

    @Test
    public void checkingGetReceipt() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"cosmo",51015);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(bun.getPrice()).thenReturn(100500F);

        String expectedResult = "(==== bun ====)\r\n= sauce cosmo =\r\n(==== bun ====)\r\n\r\nPrice: 252015,000000\r\n";
        String actualResult = burger.getReceipt();
        assertEquals(expectedResult, actualResult);
    }
}