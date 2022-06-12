import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeNegativeTest {

    private final IngredientType exampleType;
    private final IngredientType notExpectedType;

    public IngredientTypeNegativeTest(IngredientType exampleType, IngredientType notExpectedType) {
        this.exampleType = exampleType;
        this.notExpectedType = notExpectedType;
    }

    @Parameterized.Parameters(name = "тестовые данные {0}, {1}")
    public static Object[][] getIngredientTypeData() {
        Database database = mock(Database.class);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);

        return new Object[][]{
                {database.availableIngredients().get(0).getType(), FILLING},
                {database.availableIngredients().get(1).getType(), SAUCE}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void IngredientTypeNegativeTest() {
        Ingredient ingredient = new Ingredient(exampleType, "abc ingr", 100);

        IngredientType actualType = ingredient.getType();

        assertNotEquals(notExpectedType, actualType);
    }
}
