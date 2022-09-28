import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    //поля класса: для проверяемой строки и ожидаемого результата
    private final IngredientType type;
    private final String name;
    private final float price;

    // конструктор с двумя параметрами
    public IngredientParametrizedTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // метод для получения тестовых данных
    @Parameterized.Parameters(name = "{index} ==> Тестовые данные: {0} , {1} , {2}")
    public static Object[][] getTestData(){
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
        };
    }

    @Test
    public void getType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }
}
