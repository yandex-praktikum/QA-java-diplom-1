import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
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

    @Parameterized.Parameters
    public static Object[][] getInformationFoIngredient(){
        return new Object[][]{
                {SAUCE, "Острый соус", 50},
                {SAUCE, "Оc", 0},
                {FILLING, "Котлетка", 5000},
                {FILLING, "", -10},
        };
    }

    @Test
    public void setInfoForIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Неверный тип ингредиента", type, ingredient.getType());
        assertEquals("Неверное наименование ингредиента", name, ingredient.getName());
        assertEquals("Неверная цена ингредиента", price, ingredient.getPrice(), 0);
    }
}
