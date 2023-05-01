package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Котлета", 50);

    @Test
    public void getTypeTest(){
        assertEquals("Тип ингридиента не соответствует переданному в конструктор",
                ingredient.getType(), IngredientType.FILLING);
    }

    @Test
    public void getNameTest(){
        assertEquals("Имя ингридиента не соответствует переданному в конструктор",
                ingredient.getName(), "Котлета");
    }

    @Test
    public void getPriceTest(){
        assertEquals("Цена ингридиента не соответствует переданной в конструктор",
                0, ingredient.getPrice(), 50);
    }
}