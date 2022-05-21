package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerPriceTest {

    Burger burger = new Burger();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bunMock;

    @Parameterized.Parameter
    public Ingredient ingredient;

    @Parameterized.Parameter(1)
    public Ingredient ingredient1;

    @Parameterized.Parameter(2)
    public Ingredient ingredient2;

    @Parameterized.Parameter(3)
    public float ingredientsPrice;

    @Parameterized.Parameter(4)
    public float bunPrice;

    @Parameterized.Parameter(5)
    public String bunName;

    @Parameterized.Parameter(6)
    public int n;

    @Parameterized.Parameter(7)
    public float burgerPrice;

    @Parameterized.Parameters(name = "burger has got {6} ingredient/s cost {3} | bun {5} cost {4} | burger price {7}")
    public static Object[][] dataBun() {
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "Dino", 300), null, null, 300, 1000, "Cosmic", 1, 300+2*1000},
                {new Ingredient(IngredientType.SAUCE, "Cosmic", 200), new Ingredient(IngredientType.FILLING,
                        "salmon", 555.99f), null, 200+555.99f, 900, "Stellar", 2, 755.99f+900*2},
                {new Ingredient(IngredientType.FILLING, "баранина", 500), new Ingredient(IngredientType.FILLING,
                        "сыр", 105), new Ingredient(IngredientType.SAUCE, "медовый", 300), 500+300+105, 400, "гречишная", 3, 905+2*400},
        };
    }

    public void addIngredients(){
        if (n==1) {
            burger.addIngredient(ingredient);
        } else if (n==2) {
            burger.addIngredient(ingredient);
            burger.addIngredient(ingredient1);
        } else if (n==3){
            burger.addIngredient(ingredient);
            burger.addIngredient(ingredient1);
            burger.addIngredient(ingredient2);
        }
    }

    @Test
    public void burgerPriceTest(){
        burger.setBuns(bunMock);
        addIngredients();
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        assertEquals(burgerPrice, burger.getPrice(),0);
    }
}
