import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
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
        Database database = new Database();
        return new Object [][] {
                {database.availableIngredients().get(0).getType(),database.availableIngredients().get(0).getName(), database.availableIngredients().get(0).getPrice()},
                {IngredientType.SAUCE,"hot sauce", 100},
                {IngredientType.FILLING,"dinosaur", 200},
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


