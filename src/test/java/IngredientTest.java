import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
        private final IngredientType type;
        private final String name;
        private final float price;

        public IngredientTest(IngredientType type, String name, float price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][]{
                    {SAUCE, "mayonnaise", 200.45f},
                    {FILLING, "sausage", 145.0f},
                    {FILLING, "yeast-free bun", 137},
                    {SAUCE, "ketchup", 300.34f}
            };
        }

        private Ingredient ingredient;
        @Before
        public void init(){
             ingredient = new Ingredient (type, name, price);
        }

        @Test
        public void getPriceTest() {
            Assert.assertEquals(this.price, ingredient.getPrice(), 0.000001);
        }
        @Test
        public void getNameTest() {
            Assert.assertEquals(this.name, ingredient.getName());
        }
        @Test
        public void getTypeTest() {
            Assert.assertEquals(this.type, ingredient.getType());
        }


}
