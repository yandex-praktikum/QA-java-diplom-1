package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static  praktikum.IngredientType.SAUCE;
import static  praktikum.IngredientType.FILLING;

public class IngredientClassTest {

    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(8);
        price = RandomUtils.nextFloat(1,800);
        int randomNumber = RandomUtils.nextInt(0,100);

        if (randomNumber < 50) {
            type = SAUCE;
        }
        else
            type = FILLING;

        ingredient = new Ingredient(type, name, price);
    }


    @Test
    //проверить получение название ингредиента
    public void getNameTest() {
        assertEquals("Ошибка в параметре name класса Ingredient", name, ingredient.getName());
    }

    @Test
    //проверить получение цены ингредиента
    public void getPriceTest() {
        assertEquals("Ошибка в параметре price класса Ingredient", price, ingredient.getPrice(),1e-8);
    }

    @Test
    //проверить получние типа ингредиента
    public void getTypeTest() {
        assertEquals("Ошибка в параметре type класса Ingredient", type, ingredient.getType());
    }

}
