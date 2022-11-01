import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    //поля класса: для проверяемой строки и ожидаемого результата
    private final String name;
    private final float price;

    // конструктор с двумя параметрами
    public IngredientParametrizedTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    // метод для получения тестовых данных
    @Parameterized.Parameters(name = "{index} ==> Тестовые данные: {0} , {1}")
    public static Object[][] getTestData(){
        return new Object[][]{
                {"hot sauce", 100},
                {"sour cream", 200},
                {"chili sauce", 300},
        };
    }

    @Test
    public void getType(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }
}
