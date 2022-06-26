package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
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

    @Parameterized.Parameters
    public static Object[][] getIngredientData(){
        return new  Object[][] {
                {SAUCE, "Sauce", 12.000f},
                {FILLING, "Filling", 230.067f},
                {null, "", 000000.1f},
                {SAUCE, null, 100000.0006f},
                {FILLING, "NegativePrice", -4567f},
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        assertEquals(price, actual, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }
}

//С параметризацией больше половины тестов падает, не понимаю почему.
//Вот если убрать параметризацию и в каждом тестовом методе создавать экземпляр
//Ingredient с конкертными параметрами то тесты норм проходят.