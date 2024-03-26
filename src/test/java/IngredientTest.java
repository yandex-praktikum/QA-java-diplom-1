import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class IngredientTest {

    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters

    public static Object[][] checkIngredientTest() {
        return new Object [][] {
                {IngredientType.SAUCE,"Филе Люминесцентного тетраодонтимформа", 988},
                {IngredientType.FILLING,"Соус Spicy-X", 90},

        };
    }

        @Test
        public void checkNameIngredient() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals (name, ingredient.getName());
        }

        @Test
        public void checkPriceIngredient() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals (price, ingredient.getPrice(),0);
        }

        @Test

    public void checkTypeOfIngredient() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals (type, ingredient.getType());
        }
}


