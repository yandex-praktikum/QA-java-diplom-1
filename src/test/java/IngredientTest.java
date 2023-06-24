import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка возвращаемого значения названия и цены")
    public static Object[][] ingredientParameters() {
        return new Object[][]{
                {"Булка", 0},               //Цена - 0
                {"Булка", 0.46f},           //Цена - 0 + десятичные знаки
                {"Булка", 1000},            //Цена - целое число
                {"Б", 1000},                //Название - одна буква
                {"Булкааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа", 1000},
                //Название - много букв
                {"Булка-сосиска", 1000},                //Название - с тире
        };
    }

    @Test
    public void checkReturnParams() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }
}
