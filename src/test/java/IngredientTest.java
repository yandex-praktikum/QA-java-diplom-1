import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type,
                          String name,
                          float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getIngredientData(){
        return new Object[][]{
                {IngredientType.SAUCE, "black bun", 10.1f},
                {IngredientType.FILLING, "white bun", 15.0f},
        };
    }

    @Test
    public void getTypeReturnCorrectResultTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals("Неверный тип ингредиента", type, actual);
    }

    @Test
    public void getNameReturnCorrectResultTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals("Неверное имя ингредиента", name, actual);
    }

    @Test
    public void getPriceReturnCorrectResultTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        assertEquals("Неверная цена ингредиента", price, actual, 0);
    }
}

