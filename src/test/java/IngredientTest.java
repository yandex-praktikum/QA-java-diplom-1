import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Получение типа, наименования и цены ингредиента. Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "sauce", 2},         //цена - целое число
                {IngredientType.SAUCE, "sauce", 15.20f},     //цена - десятичное число
                {IngredientType.SAUCE, "а", 15.20f},         //наименование - 1 буква
                {IngredientType.FILLING, "аааааааааааааааааааааааааааааааааааааааааааааа", 50},       //наименование - много букв
                {IngredientType.FILLING, "filling", 15.20f},  //тип - FILLING
        };
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals("Наименование булки не совпадает", name, ingredient.getName());
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals("Цена булки не совпадает", price, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetType() {
        Assert.assertEquals("Ошибка: тип булки не совпадает", type, ingredient.getType());
    }
}
