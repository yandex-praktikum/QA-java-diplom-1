import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientFullTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    public IngredientFullTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceData() {
        return new Object[][]{
                {IngredientType.FILLING, "dinosaur", 10F},
                {IngredientType.SAUCE, "hot sauce", 20F}
        };
    }
    @Test
    public void checkIngredientNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String expectedName = name;

        assertEquals("Название ингредиента не совпадает.", expectedName, ingredient.getName());
    }

    @Test
    public void checkIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float expectedPrice = price;

        assertEquals("Цена ингредиента не совпадает.", expectedPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void checkIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expectedType = type;

        assertEquals("Тип ингредиента не совпадает.", expectedType, ingredient.getType());
    }
}

