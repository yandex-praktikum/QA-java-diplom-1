import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    Ingredient ingredient;

    @Before
    public void createIngredient(){
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice){
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

}
