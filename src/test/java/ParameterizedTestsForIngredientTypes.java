import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
    public class ParameterizedTestsForIngredientTypes {
    private Ingredient ingredient;
    private IngredientType ingredientType;
    @Before
    public void setUp(){
        ingredient = new Ingredient(ingredientType,"Кепчук",12.99f);
    }

        public ParameterizedTestsForIngredientTypes(IngredientType ingredientType){
            this.ingredientType=ingredientType;
        }

        @Parameterized.Parameters
        public static Object [][] getNameNegativeTest(){
            return new Object[][]{
                    {FILLING},
                    {SAUCE}
            };
        }
        @Test
        public void nameNegativeTest(){
            assertEquals(ingredientType,ingredient.getType());
        }
}
