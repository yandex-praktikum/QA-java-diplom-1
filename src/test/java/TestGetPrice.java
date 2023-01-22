import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)

public class TestGetPrice {

    private final int numberBun;
    private final int numberSAUCE;
    private final int numberFILLING;
    private final float priceFinal;


    public TestGetPrice(int numberBun, int numberSAUCE, int numberFILLING, float priceFinal) {
        this.numberBun = numberBun;
        this.numberSAUCE = numberSAUCE;
        this.numberFILLING = numberFILLING;
        this.priceFinal = priceFinal;
                    }
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { 0, 0, 3, 400},
                { 1, 1, 4, 1000},
                { 2, 2, 5, 1800},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
        @Mock
        Database database;

    Burger burger = new Burger();
    @Test
    public void getPrice() {

        List<Bun> bun = new ArrayList<>();
        bun.add(new Bun("black bun", 100));
        bun.add(new Bun("white bun", 200));
        bun.add(new Bun("red bun", 300));
        Mockito.when(database.availableBuns()).thenReturn(bun);

        List<Ingredient> ingred = new ArrayList<>();
        ingred.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingred.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingred.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        ingred.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingred.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingred.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        Mockito.when(database.availableIngredients()).thenReturn(ingred);

        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        burger.setBuns(buns.get(numberBun));
        burger.addIngredient(ingredients.get(numberSAUCE));
        burger.addIngredient(ingredients.get(numberFILLING));
        System.out.println(burger.getReceipt());
        assertEquals((priceFinal),burger.getPrice(),0);
    }

}
