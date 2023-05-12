package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;


public class IngredientTypeTest {

    @Test
    public void checkIngredientTypeName() {
        IngredientType type=IngredientType.SAUCE;
        String name = "SAUCE";
        System.out.println(type.toString());
        assertEquals("Проверка типов ингредиентов", name, type.toString());
    }
}