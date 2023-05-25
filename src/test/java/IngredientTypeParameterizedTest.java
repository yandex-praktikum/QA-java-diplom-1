import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

    public class IngredientTypeParameterizedTest {
    private IngredientType ingredientType;
    private String expectedName;

    public IngredientTypeParameterizedTest(IngredientType ingredientType, String expectedName) {
        this.ingredientType = ingredientType;
        this.expectedName = expectedName;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData(){
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}

        };
    }
        @Test
        public void getNameValue() {
            String actualName = ingredientType.name();
            assertEquals(expectedName, actualName);
        }

}
