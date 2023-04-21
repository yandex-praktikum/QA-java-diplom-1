import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

    @RunWith(Parameterized.class)
    public class IngredientTest {
        private final IngredientType type;
        private final String name;
        private final float price;
        private Ingredient ingredient;

        public IngredientTest(IngredientType type, String name, float price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters(name = "Вариант: {0} {1}")
        public static Object[][] getData() {
            return new Object[][] {
                    {SAUCE, "hot sauce", 1},
                    {SAUCE, "ketchup", 2},
                    {SAUCE, "teriyaki", 3},
                    {FILLING, "falafel", 1},
                    {FILLING, "pork", 2},
                    {FILLING, "beef patty", 3}
            };
        }

        @Before
        public void start() {
            ingredient = new Ingredient(type, name, price);
        }

        @Test
        public void testType() {
            Assert.assertEquals(type, ingredient.getType());
        }

        @Test
        public void testName() {
            Assert.assertEquals(name, ingredient.getName());
        }

        @Test
        public void testPrice() {
            Assert.assertEquals(price, ingredient.getPrice(), 0.0);
        }

    }
