import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Mock
    Ingredient ingredient;
    String name = "hot sauce";
    float price = 100;
    Database database;

    @Before
    public void setUp() {
        database = new Database();
        ingredient = database.availableIngredients().get(0);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(ingredient.getPrice(), price, 0.0f);
    }

    @Test
    public void testTestGetName() {
        Assert.assertEquals(ingredient.getName(), name);
    }

    @RunWith(Parameterized.class)
    public static class TestGetType {
        @Mock

        IngredientType type;
        Database database = new Database();
        Ingredient ingredient = database.availableIngredients().get(0);

        @Parameterized.Parameters
        public static Object[] ingredient() {
            Database database = new Database();
            return new Object[]{
                    database.availableIngredients().get(0).type,
                    database.availableIngredients().get(1).type,
                    database.availableIngredients().get(2).type,
            };
        }

        public TestGetType(IngredientType type) {
            this.type = type;
        }

        @Test
        public void testGetType() {
            Assert.assertEquals(ingredient.getType(), type);
        }

    }
}