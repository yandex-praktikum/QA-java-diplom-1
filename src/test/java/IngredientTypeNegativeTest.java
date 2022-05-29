import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeNegativeTest {

    private final IngredientType exampleType;
    private final IngredientType notExpectedType;

    public IngredientTypeNegativeTest (IngredientType exampleType, IngredientType notExpectedType){
        this.exampleType = exampleType;
        this.notExpectedType = notExpectedType;
    }

    @Parameterized.Parameters (name = "тестовые данные {0}, {1}")

    public static Object[][] getIngredientTypeData() {
        Database database = new Database();
        return new Object[][]{
                {database.availableIngredients().get(1).getType(), FILLING},
                {database.availableIngredients().get(4).getType(), SAUCE},
        };
    }
    @Test

    public void IngredientTypeNegativeTest(){
        Ingredient ingredient = new Ingredient(exampleType, "abc ingr", 100);

        IngredientType actualType = ingredient.getType();

        assertNotEquals(notExpectedType, actualType);

    }
}
