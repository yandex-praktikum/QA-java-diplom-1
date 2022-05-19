package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData(){
        return new Object[][]{
                {IngredientType.SAUCE, "chili sauce", 300f},
                {IngredientType.FILLING, "dinosaur", 200f},
                {IngredientType.FILLING, "cutlet", 100f},
                {IngredientType.SAUCE, "hot sauce", 100f}
        };
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингридиента не совпадает", type, ingredient.getType());
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название ингридиента не совпадает", name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингридиента не совпадает", price, ingredient.getPrice(), 0.0f);
    }
}
