package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String type;
    private final String name;
    private final float price;

    public IngredientTest(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип: {0}, Название: {1}, Цена: {2}")
    public static Object[][] getData() {
            return new Object[][] {
                    {"SAUCE", "Шоколад", 100},
                    {"FILLING", "Мак", 100},
                    {"FILLING", "", 100},
                    {"FILLING", " ", 100},
                    {"FILLING", " Мак", 100},
                    {"FILLING", "Мак ", 100},
                    {"FILLING", "Арахис жареный", 100},
                    {"FILLING", "Мак", 0},
                    {"FILLING", "Мак", -1},
                    {"FILLING", "Мак", 100.99f},
            };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    IngredientType ingredientTypeMock;

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientTypeMock, name, price);
        assertEquals("Цена не совпадает", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientTypeMock, name, price);
        assertEquals("Названия не совпадают", name, ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientTypeMock, name, price);
        assertEquals("Типы ингридиентов не совпадают", ingredientTypeMock.valueOf(type), ingredient.getType().valueOf(type));
    }
}