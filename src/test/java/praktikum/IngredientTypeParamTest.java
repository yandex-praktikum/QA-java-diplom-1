package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

    @RunWith(Parameterized.class)
    public class IngredientTypeParamTest {
        private final IngredientType expectedValue;
        public IngredientTypeParamTest(IngredientType expectedValue){
            this.expectedValue = expectedValue;
        }
        @Parameterized.Parameters
        public static Object[][] getType() {
            return new Object[][] {
                    {IngredientType.SAUCE},
                    {IngredientType.FILLING},
            };
        }

        @Test
        public void getTypeShouldReturnCorrectIngredientType(){
            Faker faker = new Faker();
            String testName = faker.name().firstName();
            float testPrice = faker.number().numberBetween(1, 888);
            Ingredient ingredient = new Ingredient(expectedValue, testName, testPrice);
            assertEquals(expectedValue, ingredient.getType());
        }
    }

