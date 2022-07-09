package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTests {

    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Type, name, price of ingredient: {0} {1} {2}")
    public static Object[] ingredientsData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Шаверма Деликатная", 150f},
                {IngredientType.FILLING, "Сочная начинка", 199f},
                {IngredientType.SAUCE, "Шаверма Деликатная", 150f},
                {IngredientType.FILLING, null, 199f},
                {null, "Шаверма Деликатная", 150f},
        };
    }

    @Test
    public void shouldReturnCorrectIngredientType(){
        assertEquals("Тип ингредиента должен совпадать", ingredient.getType(), type);
    }

    @Test
    public void shouldReturnCorrectName(){
        assertEquals("Наименования  должны совпасть", ingredient.getName(), name);
    }

    @Test
    public void shouldReturnCorrectPrice(){
        assertEquals("Наименования  должны совпасть", ingredient.getPrice(), price, 0);
    }

}