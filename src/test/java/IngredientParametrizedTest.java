import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

        private final String name;
        private final float price;
        private final IngredientType type;

        public IngredientParametrizedTest(IngredientType type, String name, float price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][] {

                    {IngredientType.SAUCE, "hot sauce", 100},
                    {IngredientType.SAUCE, "sour cream", 200},
                    {IngredientType.SAUCE, "chili sauce", 300},

                    {IngredientType.FILLING, "cutlet", 100},
                    {IngredientType.FILLING, "dinosaur", 200},
                    {IngredientType.FILLING, "sausage", 300}
            };
        }

        @Test
        public void getPriceIngredientTest(){
            Ingredient ingredient = new Ingredient(type, name, price);
            float actualPrice = ingredient.getPrice();
            assertEquals("Некорректная стоимость ингредиента",price, actualPrice, 0);
        }

        @Test
        public void getNameIngredientTest(){
            Ingredient ingredient = new Ingredient(type, name, price);
            String actualName = ingredient.getName();
            assertEquals("Некорректное название ингредиента", name, actualName);
        }

        @Test
        public void getTypeIngredientTest(){
            Ingredient ingredient = new Ingredient(type, name, price);
            IngredientType actualType = ingredient.getType();
            assertEquals("Некорректный тип ингридиента", type, actualType);
        }
}
