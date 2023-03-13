import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)

public class ParameterizedIngredientTest {


    private final IngredientType type;
    private final String name;
    private final float price;

    public ParameterizedIngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


        @Parameterized.Parameters
        public static Object[][] bunsIn(){
            return new Object[][]{
                    {SAUCE,"Страшная",500},
                    {FILLING,"Новая",500},
                    {null,null,500F},
            };
        }

        @Test
        public void checkResultChoose() {
            Ingredient ingredient = new Ingredient(type,name,price);
            assertEquals(ingredient.getName(),name);
            assertEquals(ingredient.getPrice(),price,0);
            assertEquals(ingredient.getType(),type);
        }


}
