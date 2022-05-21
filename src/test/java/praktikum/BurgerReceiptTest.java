package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    Burger burger = new Burger();
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bunMock;

    @Parameterized.Parameter
    public float burgerExpectedPrice;

    @Parameterized.Parameter(1)
    public int index;

    @Parameterized.Parameter(2)
    public IngredientType ingredientType;

    @Parameterized.Parameter(3)
    public String ingredientName;

    @Parameterized.Parameter(4)
    public float ingredientPrice;

    @Parameterized.Parameter(5)
    public IngredientType ingredientType1;

    @Parameterized.Parameter(6)
    public String ingredientName1;

    @Parameterized.Parameter(7)
    public float ingredientPrice1;

    @Parameterized.Parameters(name = "expected price {0} for burger with: {2} {3} and {5} {6}")
    public static Object[][] dataBurger() {
        return new Object[][]{
                {599*2+200, 1, IngredientType.SAUCE, "Cosmic", 200, null, "", 0},
                {599*2+200+555, 2, IngredientType.FILLING, "Salmon", 555, IngredientType.SAUCE, "Cosmic", 200},
        };
    }
    
    private void creatingBunMock(){
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getPrice()).thenReturn(599f);
        Mockito.when(bunMock.getName()).thenReturn("healthy");
    }

    private void addingBurgerIngredients(){
        if (index == 1) {
            burger.addIngredient(new Ingredient(ingredientType, ingredientName, ingredientPrice));
        } else {
            burger.addIngredient(new Ingredient(ingredientType, ingredientName, ingredientPrice));
            burger.addIngredient(new Ingredient(ingredientType1, ingredientName1, ingredientPrice1));
        }
    }
    
    @Test
    public void burgerReceiptTest(){
        creatingBunMock();
        addingBurgerIngredients();
        String[] actualReceipt = burger.getReceipt().split("[\\r\\n]+");
        softAssertions.assertThat(actualReceipt[0].toLowerCase()).isEqualTo("(==== healthy ====)");
        if (index == 1) {
            softAssertions.assertThat(actualReceipt[1].toLowerCase()).isEqualTo("= sauce cosmic =");
        } else {
            softAssertions.assertThat(actualReceipt[1].toLowerCase()).isEqualTo("= filling salmon =");
            softAssertions.assertThat(actualReceipt[2].toLowerCase()).isEqualTo("= sauce cosmic =");
        }
        softAssertions.assertThat(actualReceipt[index + 1]).isEqualTo("(==== healthy ====)");
        softAssertions.assertThat(actualReceipt[index + 2]).isEqualTo("Price: " + String.format("%,.2f", burgerExpectedPrice));
        softAssertions.assertAll();
    }
}
