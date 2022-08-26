package praktikum;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Enclosed.class)
public class IngredientTest {

    @RunWith(Parameterized.class)
    public static class IngredientWithParameterTest{

        private final IngredientType type;
        private final IngredientType actual;

        private String name;
        private float price;


        public IngredientWithParameterTest(IngredientType type, IngredientType actual){
            this.type = type;
            this.actual = actual;
        }

        @Parameterized.Parameters(name = "Iteration #{index} -> IngredientType = {0} AND actual = {1}")
        public static Object[][] getTypeValue(){
            return new Object[][]{

                    {IngredientType.SAUCE, IngredientType.SAUCE},
                    {IngredientType.FILLING, IngredientType.FILLING},
            };

        }

        @Test
        public void testGetIngredientType() {
            Ingredient ingredient = new Ingredient(type, name, price);

            IngredientType expected = ingredient.getType();
            assertEquals("Тип ингридиента не совпадает", expected, actual);
        }

    }

    public static class IngredientWithoutParameterTest{

        private IngredientType type = IngredientType.FILLING;
        private String name = "Котлета говяжья";
        private float price = 1596.05F;

        Ingredient ingredient = new Ingredient(type, name, price);

        @Test
        public void testGetPriceIngredient(){
            float expected = ingredient.getPrice();
            assertEquals("Цена ингридиента не возвращается", expected, price, 0);

        }

        @Test
        public void testGetNameIngredient(){
            String expected = ingredient.getName();
            assertEquals("Имя ингридиента не возвращается", expected, name);

        }

    }
    
}
