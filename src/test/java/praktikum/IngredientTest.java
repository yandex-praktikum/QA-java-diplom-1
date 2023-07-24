package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка ингридиентов. Тестовые данные: {0} {1} {2}")
    public static Object[][] getData() {
        return new Object[][] {
                { FILLING, "Мини-салат Экзо-Плантаго", 4400},
                { SAUCE, "Соус Spicy-X", 90},
        };
    }

    @Test
    public void getNameShouldReturnIngredientName(){
        Ingredient ingredient = new Ingredient(type, name, price);

        String actualResult = ingredient.getName();

        assertEquals(name,actualResult);
    }

    @Test
    public void getPriceShouldReturnIngredientPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);

        float actualResult = ingredient.getPrice();

        assertEquals(price, actualResult,0);
    }

    @Test
    public void getTypeShouldReturnIngredientType(){
        Ingredient ingredient = new Ingredient(type, name, price);

        IngredientType actualResult = ingredient.getType();

        assertEquals(type, actualResult);
    }
}
