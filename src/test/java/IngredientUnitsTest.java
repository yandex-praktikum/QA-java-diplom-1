import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientUnitsTest {

    @RunWith(Parameterized.class)
    public static class getTypeParameterizedTest {
        private final IngredientType type;
        private final IngredientType actual;
        private float price;
        private String name;

        public getTypeParameterizedTest(String type, String actual) {
            this.type = IngredientType.valueOf(type);
            this.actual = IngredientType.valueOf(actual);
        }

        @Parameterized.Parameters // добавили аннотацию
        public static Object[][] getTypeData() {
            return new Object[][]{
                    {"SAUCE", "SAUCE"},
                    {"FILLING", "FILLING"},
            };
        }
        @Test
        public void getType() throws Exception {
            Ingredient ingredient = new Ingredient(type, name, price);
            IngredientType type = ingredient.getType();
            assertEquals(type, actual);
        }
    }

    @Test
    public void getName() throws Exception {
        Ingredient ingredient = new Ingredient(FILLING, "pork", 200.0F);
        String expected = ingredient.getName();
        String actual = "pork";
        assertEquals(expected, actual);
        //return expected;
    }

    @Test
    public void getPrice() throws Exception {
        Ingredient ingredient = new Ingredient(FILLING, "pork", 200.0F);
        float expected = ingredient.getPrice();
        float actual = 200.0F;
        double delta = 0.1F;
        assertEquals(expected, actual, delta);
    }
}
