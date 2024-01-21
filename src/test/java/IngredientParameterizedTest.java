import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private Ingredient ingredient;

    private final IngredientType TYPE;
    private final String NAME;
    private final float PRICE;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.TYPE = type;
        this.NAME = name;
        this.PRICE = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][] {
                /* тип ингредиента, название, цена */
                {IngredientType.FILLING,  "Маринованные огурчики",   1.2f},
                {IngredientType.SAUCE,  "Сырный соус",   0.608f},
        };
    }


    /*  Проверка создания объектов Ingredient */
    @Before
    public void createIngredientBeforeTests(){
        createIngredient();
        assertNotNull(ingredient);
    }

    @Test
    public void getIngredientPriceIsCorrect(){
        Assert.assertEquals(PRICE, ingredient.getPrice(),0);
    }


    @Test
    public void getIngredientNameIsCorrect(){
        assertEquals("Поле name объекта ingredient не совпадает с ожидаемым", NAME, ingredient.getName());
    }

    @Test
    public void getIngredientTypeIsCorrect(){
        Assert.assertEquals(ingredient.getType(), TYPE);
    }



    /* Вспомогательные методы */
    /* создаем объект класса Ingredient */
    public void createIngredient(){
        try {
            ingredient = new Ingredient(TYPE, NAME, PRICE);
        }catch (Exception e){

        }
    }
}
