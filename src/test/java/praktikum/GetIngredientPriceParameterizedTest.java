package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetIngredientPriceParameterizedTest {

    private static final IngredientType SAUCE = IngredientType.SAUCE;
    private static final IngredientType FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final float expectedPrice;

    public GetIngredientPriceParameterizedTest(Object type, String name, float price, float expectedPrice){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100, 100},
                {SAUCE, "sour cream", 200, 200},
                {SAUCE, "chili sauce", 300, 300},
                {FILLING, "cutlet", 100, 100},
                {FILLING, "dinosaur", 200, 200},
                {FILLING, "sausage", 300, 300}
        };
    }



    @Test
    public void getPrice() {
        // Создаем объект
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        // Сохраняем полученную цену
        float actualPrice = ingredient.getPrice();
        // Проверяем, что полученная цена совпадает с ожидаемой
        assertEquals("Ожидаемая цена " + expectedPrice + ". Фактическая " + actualPrice,
                expectedPrice, actualPrice, 0);
    }


}
