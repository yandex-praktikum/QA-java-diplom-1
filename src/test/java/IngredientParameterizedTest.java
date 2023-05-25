import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
    @RunWith(Parameterized.class)

    public class IngredientParameterizedTest {
        private Ingredient ingredient;
        private float expectedPrice;
        private String expectedName;
        private IngredientType expectedType;


        public IngredientParameterizedTest(Ingredient ingredient, float expectedPrice, String expectedName, IngredientType expectedType) {
            this.ingredient = ingredient;
            this.expectedPrice = expectedPrice;
            this.expectedName = expectedName;
            this.expectedType = expectedType;
        }


        @Parameterized.Parameters
        public static Object[][] getIngredientData(){
            return new Object[][]{
                    {new Ingredient(IngredientType.FILLING, "cutlet", 100f), 100f, "cutlet", IngredientType.FILLING},
                    {new Ingredient(IngredientType.FILLING, "dinosaur", 200f), 200f, "dinosaur", IngredientType.FILLING},
                    {new Ingredient(IngredientType.FILLING, "sausage", 300f), 300f, "sausage", IngredientType.FILLING},
                    {new Ingredient(IngredientType.SAUCE, "hot sauce", 100f), 100f, "hot sauce", IngredientType.SAUCE},
                    {new Ingredient(IngredientType.SAUCE, "sour cream", 200f), 200f, "sour cream", IngredientType.SAUCE},
                    {new Ingredient(IngredientType.SAUCE, "chili sauce", 300f), 300f, "chili sauce", IngredientType.SAUCE},
            };

        }
        @Test
        public void getPriceValue() {
            float actualPrice = ingredient.getPrice();
            assertEquals(expectedPrice, actualPrice, 0.01f);
        }
        @Test
        public void getNameValue() {
            String actualName = ingredient.getName();
            assertEquals(expectedName, actualName);
        }
        @Test
        public void getTypeValue() {
            IngredientType actualType = ingredient.getType();
            assertEquals(expectedType, actualType);
        }

    }
