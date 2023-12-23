package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTests {

        @Test
        public void sauceValueTest() {
            Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
        }
        @Test
        public void fillingValueTest() {
            Assert.assertEquals( "FILLING", IngredientType.FILLING.name());
        }
}

