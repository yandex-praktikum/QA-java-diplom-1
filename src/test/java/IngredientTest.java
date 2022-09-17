import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    Ingredient ingredient;

    @Test
    @DisplayName("Constructor test")
    @Description("Тестирование конструктора")
    public void constructorTest() {
        IngredientType ingredientType = SAUCE;
        ingredient = new Ingredient(ingredientType, "hot sauce", 100);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    @DisplayName("GetPrice test")
    @Description("Тестирование метода, возвращающего цену ингредиента")
    public void getPriceTest() {
    ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    float expectedPrice = 100;
    float actualPrice = ingredient.getPrice();
    assertEquals(expectedPrice, actualPrice, 0.1);
    }
    @Test
    @DisplayName("GetName test")
    @Description("Тестирование метода, возвращающего имя ингредиента")
    public void getNameTest() {
    ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    String expectedName = "hot sauce";
    String actualName = ingredient.getName();
    assertEquals(expectedName, actualName);
    }
    @Test
    @DisplayName("GetType test")
    @Description("Тестирование метода, возвращающего тип ингредиента")
    public void getTypeTest() {
    ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    IngredientType expectedType = IngredientType.FILLING;
    IngredientType actualType = ingredient.getType();
    assertEquals(expectedType, actualType);
    }
}
