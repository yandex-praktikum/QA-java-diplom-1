package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void values() {
        assertTrue("Неверное количество типов ингредиента", IngredientType.values().length == 2);
    }

    @Test
    public void valueOf() {
        assertArrayEquals("Ожидаемый и фактический список ингридиентов не совпадают", new Object[]{"SAUCE", "FILLING"}, new Object[]{SAUCE.toString(), FILLING.toString()});
    }
}