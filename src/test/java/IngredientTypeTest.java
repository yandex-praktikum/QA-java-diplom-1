import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void fillingNotNull() {
        assertNotNull("Тест провален: укажи начинки", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("Тест провален: укажи соус", IngredientType.valueOf("SAUCE"));
    }
}