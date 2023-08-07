import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;

    private final  String name;

    private final float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name="Тестовые данные: Тип ингредиента - {0} Наименование - {1} Цена - {2}")
    public static Object[][] GetIngredientsData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Чили", 123},
                {IngredientType.FILLING, "Мясо", 345},
        };
    }

    @Test
    public void checkGetPrice() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetName() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkGetType() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}
