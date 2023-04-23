package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Тип ингредиента: {0}, Имя ингредиента: {1}, Цена: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }
    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void returnsCorrectPrice() {
        Assert.assertEquals("Некорректная цена", price, ingredient.getPrice(), 0);
    }
    @Test
    public void returnsCorrectName() {
        Assert.assertEquals("Некорректное название ингредиента", name, ingredient.getName());
    }
    @Test
    public void returnsCorrectType() {
        Assert.assertEquals("Некорректный тип ингредиента", type, ingredient.getType());
    }
    @Test
    public void setsCorrectPrice() {
        float newPrice = 150;
        ingredient.setPrice(newPrice);
        Assert.assertEquals("Некорректное изменение цены", newPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void setsCorrectName() {
        String newName = "new name";
        ingredient.setName(newName);
        Assert.assertEquals("Некорректное изменение имени", newName, ingredient.getName());
    }

    @Test
    public void setsCorrectType() {
        IngredientType newType = IngredientType.FILLING;
        ingredient.setType(newType);
        Assert.assertEquals("Некорректное изменение типа", newType, ingredient.getType());
    }
}